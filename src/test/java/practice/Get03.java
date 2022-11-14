package practice;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.internal.RealSystem;
import utilities.GMIBankBaseUrl;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get03 extends GMIBankBaseUrl {
      /*
   http://www.gmibank.com/api/tp-customers/110472 adresindeki müşteri bilgilerini doğrulayın

   "firstName": "Melva",
   "lastName": "Bernhard",
   "email": "chas.kuhlman@yahoo.com"
   "zipCode": "40207"
   "country.name": "San Jose"
   "login": "delilah.metz"
    */

    @Test
    public void name() {
        spec01.pathParams("first","tp-customers","second",110472);
        Response response=given().spec(spec01).headers("Authorization","Bearer "+generateToken()).
                when().get("/{first}/{second}");
        response.prettyPrint();
     //matcher ile dogrula
        response.then().assertThat().body("firstName",equalTo("Melva")
        , "lastName", equalTo("Bernhard")
        , "email",equalTo("chas.kuhlman@yahoo.com")
        ,"zipCode",equalTo("40207")
        ,"country.name",equalTo("San Jose")
        ,"user.login",equalTo("delilah.metz"));
        // json Path ile dogrula
        JsonPath jsonPath=response.jsonPath();
        assertEquals("Melva",jsonPath.getString("firstName"));
        assertEquals("Bernhard",jsonPath.getString("lastName"));
        assertEquals("chas.kuhlman@yahoo.com",jsonPath.getString("email"));
        assertEquals("40207",jsonPath.getString("zipCode"));
        assertEquals("San Jose",jsonPath.getString("country.name"));
        assertEquals("delilah.metz",jsonPath.getString("user.login"));
    }
}
