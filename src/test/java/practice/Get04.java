package practice;

import io.restassured.response.Response;
import org.junit.Test;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Get04 extends GMIBankBaseUrl {
    /*
          http://www.gmibank.com/api/tp-customers/43703
​
          "firstName": "Alda",
          "lastName": "Monahan",
          "middleInitial": "Nichelle Hermann Kohler",
          "email": "com.github.javafaker.Name@7c011174@gmail.com",
          "mobilePhoneNumber": "909-162-8114",
          "city": "St Louis",
          "ssn": "108-53-6655"
​
          1) MATCHERS CLASS
          2) JSON PATH
          3) De-Serialization
    */

    @Test
    public void adas() {
        spec01.pathParams("first","tp-customers","second",43703);
        Response rresponse =given().spec(spec01).headers("Authorization","Bearer "+generateToken()).when().get("/{first}/{second}");
        rresponse.prettyPrint();
        //matcher class ile dogruala
        rresponse.then().assertThat().body("firstName",equalTo("Alda")
                , "lastName", equalTo("Monahan")
                , "email",equalTo("com.github.javafaker.Name@7c011174@gmail.com")
                ,"middleInitial",equalTo("Nichelle Hermann Kohler")
                ,"mobilePhoneNumber",equalTo("909-162-8114")
                ,"city",equalTo("St Louis")
                ,"ssn",equalTo("108-53-6655"));
    }
}
