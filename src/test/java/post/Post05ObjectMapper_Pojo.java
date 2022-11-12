package post;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
      /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post05() {
        spec.pathParam("first","todos");
        JsonPojo expectedData=new JsonPojo(55,"Tidy your room",false);
        Response response =given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        JsonPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPojo.class);
        System.out.println(actualData);
        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
    }
}
