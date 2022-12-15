package com.sbrown52.jsonimport.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ImportUtils {
    private static Logger log = LogManager.getLogger(ImportUtils.class);

    public static List<String> lines(String json) {
        if (json == null)
            return Collections.emptyList();

        String[] split = json.split("[\\r\\n]+");
        return Arrays.asList(split);
    }

    public static List<String> lines(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            log.error("reading lines from " + file, e);
            return null;
        }
    }

    public static List<String> linesFromResource(String resource) {
        Resource input = new ClassPathResource(resource);
        try {
            Path path = input.getFile()
                    .toPath();
            return Files.readAllLines(path);
        } catch (IOException e) {
            log.error("reading lines from classpath resource: " + resource, e);
            return null;
        }
    }
}
