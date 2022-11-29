import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.UserNQ;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US001ApiStep {
    Response response;
    UserNQ actualData;
    UserNQ expectedData;
    @Given("nq Medunna")
    public void nqMedunna() {

    }
    Integer sayac=1;

    @When("nq send Get request")
    public void nqSendGetRequest() {
        response = given().headers("Authorization", "Bearer " + generateToken()).when().get("https://medunna.com/api/user?ssn=607-69-5698");
response.prettyPrint();
    }

    @Then("nq Status code is {int}")
    public void nqStatusCodeIs(int statuscode) {
        response.then().assertThat().statusCode(statuscode);
    }

    @And("nq Verifies that valid username is also api")
    public void nqVerifiesThatValidUsernameIsAlsoApi() {
       actualData=response.as(UserNQ.class);
        assertEquals("nurettinq",actualData.getLogin());
    }

    @And("nq Verifies that valid firstname is also api")
    public void nqVerifiesThatValidFirstnameIsAlsoApi() {
        assertEquals("nur",actualData.getFirstName());
    }

    @And("nq Verifies that valid lastname is also api")
    public void nqVerifiesThatValidLastnameIsAlsoApi() {
        assertEquals("ettin",actualData.getLastName());
    }

    @And("nq Verifies that valid email is also api")
    public void nqVerifiesThatValidEmailIsAlsoApi() {
        assertEquals("n@e.com",actualData.getEmail());
    }

    @When("nq send post request by entering {string} ,{string}, {string}, {string}, {string}")
    public void nqSendPostRequestByEntering(String firstnane, String lastname, String email, String login, String ssn) {

         expectedData = new UserNQ(null, Faker.instance().name().username(), "672-23-1245", "nur", "ettin", Faker.instance().internet().emailAddress(), null, null, null, null, null, null);
        response = given().headers("Authorization", "Bearer " + generateToken()).when().contentType(ContentType.JSON).body(expectedData).post("https://medunna.com/api/users");
       response.prettyPrint();
    }

    @And("nq Verifies the entered {string} ,{string}, {string}, {string}, {string}")
    public void nqVerifiesTheEntered(String arg0, String arg1, String arg2, String arg3, String arg4) {
        UserNQ actualData =response.as(UserNQ.class);
        assertEquals(expectedData.getLogin(),actualData.getLogin());
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());


    }
}
