package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get12Pojo extends RestfulBaseUrl {

        /*
        Given
            https://restful-booker.herokuapp.com/booking/19
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
 		             {
    "firstname": "James",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get12Pojo() {
        spec.pathParams("first","booking","second",19);
        //set the expexted data
        BookingDatePojo bookingDatePojo=new BookingDatePojo("2018-01-01","2019-01-01");
        BookingPojo expectedbookingPojo=new BookingPojo("James","Brown","Breakfast",true,111,bookingDatePojo);
        System.out.println(expectedbookingPojo.toString());

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        BookingPojo actualData=response.as(BookingPojo.class);
        assertEquals(expectedbookingPojo.getFirstname(),actualData.getFirstname());
        assertEquals(expectedbookingPojo.getLastname(),actualData.getLastname());
        assertEquals(expectedbookingPojo.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedbookingPojo.getAdditionalsneeds(),actualData.getAdditionalsneeds());
        assertEquals(expectedbookingPojo.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedbookingPojo.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedbookingPojo.getDepositpaid(),actualData.getDepositpaid());




    }
}
