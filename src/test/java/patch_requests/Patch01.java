package patch_requests;

import TestDAta.JsonTestData;
import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonplaceholderBaseUrl {

      /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "title": "Wash the dishes"
               }
        When
	 		I send PATCH Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 10,
									    "title": "Wash the dishes",
									    "completed": true,
									    "id": 198
									    }
     */

    @Test
    public void post01() {
        spec.pathParams("first","todos","second","198");
        //set the expected data;
        JsonTestData jsonTestData=new JsonTestData();
        Map<String,Object> expecedDatas=jsonTestData.expectedData(null,"ders calis artik",null);
        System.out.println(expecedDatas);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expecedDatas).when().patch("/{first}/{second}");
       response.prettyPrint();
       Map<String,Object> actualData=response.as(HashMap.class);
       assertEquals(200, response.statusCode());
       assertEquals(expecedDatas.get("title"),actualData.get("title"));


    }
}
