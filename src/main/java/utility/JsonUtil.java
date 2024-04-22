package utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static List<Map<String, String>> readJsonData(String filePath) throws IOException, ParseException {
        FileReader reader = new FileReader(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
        List<Map<String, String>> dataList = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("email", (String) jsonObject.get("email"));
            dataMap.put("password", (String) jsonObject.get("password"));
            dataList.add(dataMap);
        }

        reader.close();
        return dataList;
    }
}