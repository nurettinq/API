package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
     /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                  {
                    "firstname": "Guoqiang",
                    "lastname": "Morante Briones",
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
    public void get15() {
        spec.pathParams("first", "booking","second",22);
        BookingDatePojo bookingDatePojo=new BookingDatePojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Guoqiang","Morante Briones",111,true,bookingDatePojo,"Breakfast");
        Response response=given().spec(spec).when().get("/{first}/{second}");
        BookingPojo actualData=response.as(BookingPojo.class);
        System.out.println(actualData);
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalsneeds(),actualData.getAdditionalsneeds());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());
    }
}
