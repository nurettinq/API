package get_requests;

import TestDAta.JsonTestData;
import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get14ObjectMapperMap extends JsonplaceholderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get() {
     spec.pathParams("first","todos","second",198);
    String expectedData= new JsonTestData().expectedDataInString(10,"quis eius est sint explicabo",true);
        Map expData=ObjectMapperUtils.convertJsonToJava(expectedData, Map.class);
    Response response=given().spec(spec).when().get("/{first}/{second}");
    Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);
        System.out.println(actualData);
        assertEquals(200,response.getStatusCode());
        assertEquals(expData.get("userId"),actualData.get("userId"));
        assertEquals(expData.get("title"),actualData.get("title"));
        assertEquals(expData.get("completed"),actualData.get("completed"));
        }
}
