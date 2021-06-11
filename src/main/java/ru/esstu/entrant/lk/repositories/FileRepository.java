package ru.esstu.entrant.lk.repositories;

import org.apache.ibatis.annotations.*;
import ru.esstu.entrant.lk.domain.dto.FileDto;
import ru.esstu.entrant.lk.domain.vo.Consent;
import ru.esstu.entrant.lk.domain.vo.EntrantPrivateData;
import ru.esstu.entrant.lk.domain.vo.File;

import java.util.List;
@Mapper
public interface FileRepository {
    @Select("SELECT * FROM entrant_files WHERE entrant_id = #{id}")
    List<File> getFiles(@Param("id") int id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("INSERT INTO entrant_files(entrant_id, file_name, file_extension, document_type,guid)" +
            "VALUES(#{file.entrantId},#{file.fileName},#{file.fileExtension},#{file.documentType},#{file.guid})")
    long save(@Param("file") File file);
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Delete("Delete From entrant_files " +
            "Where entrant_files.guid=guid")
    long delete(@Param("guid") String guid);
}
