package get_requests;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06p extends ReqresBaseUrl {
    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
            3)Print all ids greater than 3 on the console
              Assert that there are 3 ids greater than 3
            4)Print all names whose ids are less than 3 on the console
              Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void get06() {
     spec.pathParams("first","unknown");
     Response response=given().spec(spec).when().get("/{first}");
     assertEquals(200,response.getStatusCode());
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        System.out.println(jsonPath.getList("data.pantone_value"));
        System.out.println(jsonPath.getList("data.findAll{it.id>3}.id"));
        assertEquals(3,jsonPath.getList("data.findAll{it.id>3}.id").size());
        System.out.println(jsonPath.getList("data.findAll{it.id<3}.name"));
        assertEquals(2,jsonPath.getList("data.findAll{it.id<3}.name").size());


    }
}
