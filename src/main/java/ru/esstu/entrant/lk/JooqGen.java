package ru.esstu.entrant.lk;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.resource.ResourceAccessor;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.Configuration;
import org.jooq.meta.jaxb.Generator;
import org.jooq.meta.jaxb.Jdbc;
import org.jooq.meta.jaxb.Schema;
import org.jooq.meta.jaxb.Target;
import org.testcontainers.containers.PostgreSQLContainer;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Duration;

/**
 * Генератор схемы jooq.
 */
public class JooqGen {

    /**
     * @param args аргументы для запуска
     */
    public static void main(String[] args) {
        try {
            String changelogFile = "/liquibase/db.changelog-master.xml";
            String sourceDirectory = "src/main/java";

            PostgreSQLContainer postgreSQLContainer =
                    (PostgreSQLContainer) new PostgreSQLContainer("kartoza/postgis:10.0-2.4")
                            .withDatabaseName("service")
                            .withUsername("service")
                            .withPassword("service")
                            .withStartupTimeout(Duration.ofSeconds(600));
            postgreSQLContainer.start();
            Connection connection = postgreSQLContainer.createConnection("");

            String jdbcUrl = postgreSQLContainer.getJdbcUrl();
            URL changelog = JooqGen.class.getResource(changelogFile);
            System.out.println("postgres url:" + jdbcUrl);
            System.out.println("changelog file:" + changelog);

            runLiquibase(connection, changelog);
            cleanOldGeneratedSource(sourceDirectory);
            generateSource(sourceDirectory, postgreSQLContainer, jdbcUrl);

            postgreSQLContainer.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Сгенерировать схему.
     *
     * @param sourceDirectory     директория с исходниками схемы
     * @param postgreSQLContainer контейнер БД
     * @param jdbcUrl             УЛР для подключения к БД
     */
    private static void generateSource(String sourceDirectory, PostgreSQLContainer postgreSQLContainer, String jdbcUrl) {
        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl(jdbcUrl)
                        .withUser(postgreSQLContainer.getUsername())
                        .withPassword(postgreSQLContainer.getPassword()))
                .withGenerator(new Generator()
                        .withName("org.jooq.codegen.DefaultGenerator")
                        .withDatabase(new org.jooq.meta.jaxb.Database()
                                .withName("org.jooq.meta.postgres.PostgresDatabase")
                                .withIncludes(withIncludes())
                                .withExcludes("DATABASECHANGELOGLOCK*|DATABASECHANGELOG*")
                                .withSchemata(new Schema().withInputSchema("public"))
                        )
                        .withTarget(new Target()
                                .withPackageName("ru.esstu.entrant.lk.jooq")
                                .withDirectory(sourceDirectory)));
        try {
            GenerationTool.generate(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String withIncludes() {
        return "";
    }

    /**
     * Выполнить liquibase на БД.
     *
     * @param connection коннект к БД
     * @param changelog  файл с ченьжлогом
     * @throws LiquibaseException ...
     */
    private static void runLiquibase(Connection connection, URL changelog) throws LiquibaseException {
        try {
            String path = JooqGen.class.getResource("/liquibase").getPath().replace("/liquibase", "");
            ResourceAccessor resourceAccessor = new FileSystemResourceAccessor(path);
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new Liquibase(changelog.getPath(), resourceAccessor, database);
            liquibase.update("");
        } finally {
            if (connection != null) {
                try {
                    connection.rollback();
                    connection.close();
                } catch (SQLException e) {
                    //nothing to do
                }
            }
        }
    }

    /**
     * Удалить файлы из указанной директории.
     *
     * @param path путь к директории
     */
    private static void cleanOldGeneratedSource(String path) {
        Path dir = Paths.get(System.getProperty("user.dir"), path);
        File file = dir.toFile();
        System.out.println("clean " + dir);
        file.deleteOnExit();
    }
}
