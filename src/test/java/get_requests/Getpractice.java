package get_requests;

import base_url.RestapiExampleUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.apache.http.conn.ConnectTimeoutException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Getpractice extends RestapiExampleUrl {
      /*
http://dummy.restapiexample.com/api/v1/employees  url'ine
GET request'i yolladigimda gelen response'un
status kodunun 200 ve content type'inin "application/json"
ve employees sayisinin 24
ve employee'lerden birinin "Ashton Cox"
ve gelen yaslar icinde 21, 61, ve 23 degerlerinden birinin oldugunu test edin.
*/

    @Test
    public void get01() {
        spec.pathParams("first","v1","second","employees");
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.getContentType());
        assertEquals(24,jsonPath.getList("data.id").size());
        System.out.println(jsonPath.getList("data.id").size());
        assertTrue(jsonPath.getList("data.employee_name").contains("Ashton Cox"));
        List<Integer> list=new ArrayList<>(Arrays.asList(61,63,66));
        System.out.println(list);
        System.out.println(jsonPath.getList("data.employee_age"));
      //  assertTrue((jsonPath.getList("data.employee_age")).contains);
    }
}
