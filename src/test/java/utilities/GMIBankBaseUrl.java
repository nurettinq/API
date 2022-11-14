package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utils.Authentication;

import static io.restassured.RestAssured.given;

public class GMIBankBaseUrl extends Authentication {
    protected RequestSpecification spec01;
    @Before
    public void setUp(){
        spec01=new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api/").build();
    }
}
