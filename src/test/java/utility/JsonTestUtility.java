package utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonTestUtility {

    public static void writeDataToJson(String filePath, Map<String, String> data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        // Read the existing data from the JSON file
        List<Map<String, String>> existingData = mapper.readValue(file, new TypeReference<List<Map<String, String>>>(){});

        // Add the new data to the existing data
        existingData.add(data);

        // Write the updated data back to the JSON file
        mapper.writeValue(file, existingData);
    }

    public static int getJsonDataCount(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);

        // Read the data from the JSON file
        List<Map<String, String>> data = mapper.readValue(file, new TypeReference<List<Map<String, String>>>(){});

        // Return the number of data sets in the JSON file
        return data.size();
    }
}