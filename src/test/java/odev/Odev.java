package odev;

import base_url.AutoBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Odev extends AutoBaseUrl {   /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
         */
    @Test
    public void odev() {
        spec.pathParams("first","brandsList");
        Response response=given().spec(spec).when().get("/{first}");
     //   response.prettyPrint();


        List<String>list= response.htmlPath().getList("brands.brand");
        long hm=list.stream().filter(t->t.equals("H&M")).count();
        long polo=list.stream().filter(t->t.equals("Polo")).count();
        System.out.println(hm);
        System.out.println(polo);
        assertEquals(hm, polo);
    }
}
