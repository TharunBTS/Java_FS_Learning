package FileProcessing;

import FileToPOJO.Modules;

import java.io.*;
import java.nio.file.*;
import java.util.*;
public class FileProcess {
    public static void main(String[] args) throws Exception{


        String baseDir = "InputDirectory";
        String controlDir = "Control";
        Map<String, List<File>> dateToFileMap = new TreeMap<>();
        File bankDir = new File(baseDir);
        File controlFolder = new File(controlDir);



        if (!controlFolder.exists()) {
            controlFolder.mkdirs();
        }
        if (bankDir.isDirectory()) {
            for (File file : Objects.requireNonNull(bankDir.listFiles((d, name) -> name.endsWith(".txt")))) {
                try (var lines = Files.lines(file.toPath())) {
                    String header = lines.findFirst().orElse(null);
                    if (header != null && header.startsWith("HDR|")) {
                        String[] parts = header.split("\\|");
                        if (parts.length >= 3) {
                            String dateStr = parts[1];
                            dateToFileMap.computeIfAbsent(dateStr, k -> new ArrayList<>()).add(file);
                        }
                    }
                }
            }
        }


        for (Map.Entry<String, List<File>> entry : dateToFileMap.entrySet()) {
            String dateStr = entry.getKey();
            List<File> files = entry.getValue();
            File dateFolder = new File(controlFolder, dateStr);


            if (!dateFolder.exists()) {
                dateFolder.mkdirs();
            }

            for (File file : files) {
                Path targetPath = new File(dateFolder, file.getName()).toPath();
                Files.copy(file.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
            }
        }

        Modules module = new Modules();
        module.toPojo();

    }
}




