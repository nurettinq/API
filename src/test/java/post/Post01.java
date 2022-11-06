package post;

import TestDAta.GoRestTestData;
import TestDAta.JsonTestData;
import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonplaceholderBaseUrl {
     /*
         Given
           1)  https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 66,
                 "title": "nurettin",
                 "completed": false
                }
        When
         I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 66,
                                    "title": "nurettin",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //Set the expected Data

        spec.pathParams("first","todos");
        JsonTestData jsonTestData=new JsonTestData();
        Map<String,Object> jsonPost=jsonTestData.expectedData(66,"nurettin",false);
        //Send the Request and Get the response
       Response response= given().spec(spec).contentType(ContentType.JSON).body(jsonPost).when().post("/{first}");
        response.prettyPrint();
        //Do assertion
        Map<String,Object> actualData=response.as(HashMap.class);
        assertEquals(jsonPost.get("userId"),actualData.get("userId"));
        assertEquals(jsonPost.get("completed"),actualData.get("completed"));
        assertEquals(jsonPost.get("title"),actualData.get("title"));
    }
}
