package post;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;
import pojos.BookingReaponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends RestfulBaseUrl { /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        },
                                        "additionalneeds": "Breakfast"
                                     }
                                  }
     */

    @Test
    public void post() {
        spec.pathParam("first","booking");
        BookingDatePojo bookingDatePojo=new BookingDatePojo("2021-09-21","2021-12-21");
        BookingPojo expectedData=new BookingPojo("Ali","Can",999,true,bookingDatePojo,null);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        BookingReaponseBodyPojo actualData=response.as(BookingReaponseBodyPojo.class);
        System.out.println(actualData);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getAdditionalsneeds(),actualData.getBooking().getAdditionalsneeds());
        assertEquals(expectedData.getBookingdates().getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getBookingdates().getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getAdditionalsneeds(),actualData.getBooking().getAdditionalsneeds());



    }
}
