package odev;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.ReqrePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class HM03 extends ReqresBaseUrl {
/*
        Given
            1) https://reqres.in/api/users/2
            2) {
                "name": "morpheus",
                "job": "zion president"
                }
        When
            I send Put Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "zion president",
                                                "updatedAt": "2022-10-02T11:35:05.693Z"
                                            }
*/

    @Test
    public void name() {
        spec.pathParams("first","users","second",2);
        ReqrePojo expectData=new ReqrePojo("nur","sdet");
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectData).when().put("/{first}/{second}");
        ReqrePojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),ReqrePojo.class);
        System.out.println(actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectData.getName(),actualData.getName());
        assertEquals(expectData.getJob(),actualData.getJob());
    }
}
