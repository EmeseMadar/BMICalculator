package bmi.beadando;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class WriteJSON {

    private int passed = 0;
    private int failed = 0;

    public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    UnitTestCounter unitTestCounter = new UnitTestCounter();
    objectMapper.writeValue(new File("test_results.json"),unitTestCounter);
    }
}