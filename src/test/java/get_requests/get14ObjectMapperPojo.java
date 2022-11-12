package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get14ObjectMapperPojo extends JsonplaceholderBaseUrl {
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
        JsonPojo expected=new JsonPojo(10,"quis eius est sint explicabo",true);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        JsonPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPojo.class);
        assertEquals(200,response.getStatusCode());
        assertEquals(expected.getUserId(),actualData.getUserId());
        assertEquals(expected.getTitle(),actualData.getTitle());
        assertEquals(expected.getCompleted(),actualData.getCompleted());
    }
}
