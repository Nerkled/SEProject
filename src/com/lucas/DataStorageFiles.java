package com.lucas;
import com.lucas2.InMemoryInputConfig; //Gradle isnt seeing this import
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import com.lucas2.InMemoryInputConfig;

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
            String[] numbers = result.split("\n");
            for (String number : numbers) {
                fileWriter.write(number + "\n");
            }
            System.out.println("Write operation successful!");
            return () -> Result.ResultStatus.SUCCESS;
        } catch (IOException e) {
            System.err.println("Error writing to file: " + filePath);
            e.printStackTrace();
            return () -> Result.ResultStatus.FAILURE;
        }
    }
    public class Main {
        public static void main(String[] args) {
            StorageToComputeEngineAPI dataStorage = new DataStorageFiles("test/com/lucas2/testInputFile.test");
            InputConfig input = new InMemoryInputConfig();
            List<Integer> data = dataStorage.read(input); 
            System.out.println("Data read from file: " + data);
        } 
    } 
    
} 