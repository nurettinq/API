package get_requests;

import TestDAta.GoRestTestData;
import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class get13pojo extends GoRestBaseUrl {

    @Test
    public void get13() {
 /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                "id": 2508,
                "name": "Sharmila Deshpande VM",
                "email": "deshpande_sharmila_vm@becker.name",
                "gender": "female",
                "status": "active"
                 }
          }
    */
        spec.pathParams("first","users","second",2508);
        GoRestDataPojo goRestDataPojo=new GoRestDataPojo(2508,"Vasundhara Nayar Ret.","ret_vasundhara_nayar@renner.co","female", "inactive");
        GoRestPojo expectedData=new GoRestPojo(null,goRestDataPojo);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        GoRestPojo actualData=response.as(GoRestPojo.class);
        System.out.println(actualData);
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        assertEquals(expectedData.getData().getName(),actualData.getData().getName());
        assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(expectedData.getData().getStatus(),actualData.getData().getStatus());
    }
}
