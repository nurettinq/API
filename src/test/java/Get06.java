import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Get06 extends RestfulBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2022-10-27",
        "checkout": "2022-11-07"
    },
    "additionalneeds": "None"
}
     */

    @Test
    public void name() {
        Response response=given().when().spec(spec.pathParams("first","booking","second",2325))
                .get("/{first}/{second}");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).body("firstname", equalTo("Bradley"),
                "lastname", equalTo("Pearson"),
                "totalprice", equalTo(132),
                "depositpaid", equalTo(false),
                "bookingdates.checkin", equalTo("2022-10-27"),
                "bookingdates.checkout", equalTo("2022-11-07"),
                "additionalneeds", equalTo("None"));

        JsonPath json=response.jsonPath();
        assertEquals("Pearson",json.getString("lastname"));
        assertEquals(132,json.getInt("totalprice"));
        assertFalse(json.getBoolean("depositpaid"));
        assertEquals("2022-10-27",json.getString("bookingdates.checkin"));
        assertEquals("2022-11-07",json.getString("bookingdates.checkout"));
        assertEquals("None",json.getString("additionalneeds"));

    }
}
