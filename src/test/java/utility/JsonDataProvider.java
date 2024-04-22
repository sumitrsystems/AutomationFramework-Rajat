package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonDataProvider {
    @DataProvider(name = "jsonDataFirstSet")
    public Object[][] provideFirstSetData() {
        Object[][] data = new Object[1][2];
        try {
            List<Map<String, String>> dataList = JsonUtil.readJsonData("C:\\Users\\Rajat\\IdeaProjects\\untitled\\src\\main\\java\\data\\testdata.json");
            Map<String, String> dataMap = dataList.get(0); // Get the first set of data
            data[0][0] = dataMap.get("email");
            data[0][1] = dataMap.get("password");
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "jsonDataSecondSet")
    public Object[][] provideSecondSetData() {
        Object[][] data = new Object[1][2];
        try {
            List<Map<String, String>> dataList = JsonUtil.readJsonData("src/main/java/data/testdata.json");
            Map<String, String> dataMap = dataList.get(1); // Get the second set of data
            data[0][0] = dataMap.get("email");
            data[0][1] = dataMap.get("password");
        } catch (IOException | org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}