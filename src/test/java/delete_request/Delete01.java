package delete_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01 extends JsonplaceholderBaseUrl {
      /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */

    @Test
    public void delete() {
        spec.pathParams("first","todos","second",198);
        Response response=given().spec(spec).when().delete("/{first}/{second}");
      assertEquals(200,response.getStatusCode());

    }
}
