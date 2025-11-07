package org.example.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DataDriven {

    // Method to read username and password from JSON file
    public static Map<String, String> getCredentials(String key) {
        Map<String, String> data = new HashMap<>();

        try {
            // 1. Create JSON mapper
            ObjectMapper mapper = new ObjectMapper();

            // 2. Read JSON file (make sure the path is correct)
            File file = new File("C:\\Users\\salwa\\AppData\\Roaming\\JetBrains\\IntelliJIdea2025.2\\scratches\\testData.json");

            // 3. Read all data from JSON
            JsonNode root = mapper.readTree(file);

            // 4. Go to the specific section (valid / invalid / noPassword)
            JsonNode node = root.path(key);

            // 5. Put username and password into a map
            data.put("username", node.path("username").asText());
            data.put("password", node.path("password").asText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
