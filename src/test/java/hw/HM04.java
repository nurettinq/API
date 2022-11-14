package hw;

import TestDAta.ReqreTestDAat;
import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HM04 extends ReqresBaseUrl {
      /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void name() throws IOException {
    spec.pathParams("first","users","second",2);
        Map<String,String> expextedData=new ReqreTestDAat().expectedData("nurettin",null);
        System.out.println(expextedData);
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expextedData).when().patch("/{first}/{second}");
        Map<String,String> actualData=new ObjectMapper().readValue(response.asString(),Map.class);
        System.out.println(actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expextedData.get("name"),actualData.get("name"));
    }
}
