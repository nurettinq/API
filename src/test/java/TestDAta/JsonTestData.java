package TestDAta;

import java.util.HashMap;
import java.util.Map;

public class JsonTestData {
    // "userId": 1,
    //        "id": 1,
    //        "title": "delectus aut autem",
    //        "completed": false
    public Map<String,Object> expectedData(Integer userId, String title, Boolean completed){
        Map<String,Object> expectedData=new HashMap<>();
        if (userId != null) {
            expectedData.put("userId",userId);
        }

        if (title != null) {
            expectedData.put("title", title);
        }
            if (completed != null) {
                expectedData.put("completed", completed);
            }



        return expectedData;
    }
}
