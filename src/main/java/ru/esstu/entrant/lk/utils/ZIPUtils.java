package ru.esstu.entrant.lk.utils;

import io.undertow.util.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Slf4j
public class ZIPUtils {

    public static void unzip(byte[] zip, String directory, String file) throws IOException {
        rmdirs(directory + "/" + file);
        mkdirs(directory + "/" + file);

        File path = new File(directory + "/" + file, file + ".zip");

        try (OutputStream stream = new FileOutputStream(path)) {
            stream.write(zip);
        }

        unzip(path, directory + "/" + file);
    }

    public static void unzip(File zip, String directory) throws IOException {
        try (ZipFile file = new ZipFile(zip)) {
            FileSystem fileSystem = FileSystems.getDefault();
            Enumeration<? extends ZipEntry> entries = file.entries();

            mkdirs(directory);

            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.isDirectory()) {
                    mkdirs(directory  + "/" + entry.getName());
                } else {
                    InputStream is = file.getInputStream(entry);
                    BufferedInputStream bis = new BufferedInputStream(is);
                    String uncompressedFileName = directory + "/" + entry.getName();
                    Files.createFile(fileSystem.getPath(uncompressedFileName));
                    FileOutputStream fileOutput = new FileOutputStream(uncompressedFileName);
                    while (bis.available() > 0) {
                        fileOutput.write(bis.read());
                    }
                    fileOutput.close();
                }
            }
        }
    }

    private static void rmdirs(String directory) throws IOException {
        FileUtils.deleteRecursive(new File(directory).toPath());
    }

    private static void mkdirs(String directory) {
        log.info("create directory {}, {}", directory, new File(directory).mkdirs());
    }
}
