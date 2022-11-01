import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05 extends RestfulBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
         Among the data there should be someone whose firstname is "Johhny" and lastname is "Dear"
     */

    @Test
    public void name() {
        spec.pathParam("f","booking").queryParams("firstname","Ali","lastname","Cengiz");
        Response response=given().when().spec(spec).get("/{f}");
        response.then().assertThat().statusCode(200);
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));
        response.prettyPrint();
    }
}
