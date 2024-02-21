package com.lucas;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataStorageFiles implements StorageToComputeEngineAPI {

    private String filePath;

    public DataStorageFiles(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Integer> read(InputConfig input) {
        List<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                try {
                    int value = Integer.parseInt(data);
                    list.add(value);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing data: " + data);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Result write(OutputConfig output, String result) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(result);
            System.out.println("Write operation successful!");
            return () -> Result.ResultStatus.SUCCESS;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
            return () -> Result.ResultStatus.FAILURE;
        }
    }
}
