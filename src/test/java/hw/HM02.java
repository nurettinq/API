package hw;

import TestDAta.ReqreTestDAat;
import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.ReqrePojo;
import utils.ObjectMapperUtils;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HM02 extends ReqresBaseUrl {
      /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
*/

    @Test
    public void post() {
        spec.pathParam("first","users");
        ReqrePojo expectedData=new ReqrePojo("nurettin","engineer");
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();
        ReqrePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),ReqrePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getJob(),actualData.getJob());



    }

    @Test
    public void name() throws IOException {
        spec.pathParam("first","users");
        Map<String,String> expectedData =new ReqreTestDAat().expectedData("nurettin","tester");
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        Map<String,String>actualData=new ObjectMapper().readValue(response.asString(),Map.class);
        System.out.println(actualData);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));
        assertEquals(expectedData.get("job"),actualData.get("job"));

    }
}
