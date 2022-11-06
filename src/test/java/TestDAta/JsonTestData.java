package TestDAta;

import java.util.HashMap;
import java.util.Map;

public class JsonTestData {
    // "userId": 1,
    //        "id": 1,
    //        "title": "delectus aut autem",
    //        "completed": false
    public Map<String,Object> expectedData(int userId, String title, Boolean completed){
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("userId",userId);
        expectedData.put("title",title);
        expectedData.put("compşeted",completed);

        return expectedData;
    }
}
