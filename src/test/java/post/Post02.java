package post;

import TestDAta.RestfulTestData;
import base_url.RestfulBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends RestfulBaseUrl {
    //"firstname": "James",
    //            "lastname": "Brown",
    //            "totalprice": 8076,
    //            "depositpaid": true,
    //            "bookingdates": {
    //        "checkin": "2018-01-01",
    //                "checkout": "2019-01-01"
    //
    //            "additionalneeds": "Breakfast"
    @Test
    public void post02() {
        spec.pathParam("first","booking");
        RestfulTestData restfulTestData=new RestfulTestData();
        Map<String,Object>expectedData= restfulTestData.restfulexpect("nurettin","güzel",1066,true,"dinner",restfulTestData.bookingDatesMethods("2022-01-07","2022-01-27"));

        Response response= (Response) RestAssured.given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
       response.prettyPrint();
      //  Map<String, Object> actualData=response.as(HashMap.class);
      //  assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
      //  assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
      //  assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
      //  assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
      //  assertEquals(expectedData.get("bookingdates"), actualData.get("bookingdates"));
      //  assertEquals(expectedData.get("additionalneeds"), actualData.get("additionalneeds"));




    }
}
