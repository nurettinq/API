package TestDAta;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {
//{
//            "meta": null,
//            "data": {
//                "id": 2508,
//                "name": "Sharmila Deshpande VM",
//                "email": "deshpande_sharmila_vm@becker.name",
//                "gender": "female",
//                "status": "active"
//                 }
//          }

    public Map<String,String> dataKeyMap(String name, String email, String gender, String status){
    Map<String,String > dataKeyMap = new HashMap<>();
    dataKeyMap.put("name",name);
    dataKeyMap.put("email",email);
    dataKeyMap.put("gender",gender);
    dataKeyMap.put("status",status);

    return dataKeyMap;
}

    public Map<String,Object> expectedDataMethod(Object meta,Map<String ,String> data){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("meta",meta);
        expectedData.put("data",data);

        return expectedData;
    }
}

