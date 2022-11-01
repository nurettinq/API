package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Get04p extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Jimin" and lastname is "Park"

     */

    @Test
    public void get04() {
     spec.pathParams("first","booking").queryParams("firstname","Jimin","lastname","Park");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        response.then().statusCode(200);
        assertTrue(response.asString().contains("bookingid"));

    }
}
