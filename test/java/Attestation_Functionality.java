import Pojo.Campus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Attestation_Functionality {


    private RequestSpecification reqSpec;
    private Campus user = new Campus();
    private HashMap<String, String> credentials;
    private Cookies cookies;


    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://demo.mersys.io/";

        reqSpec = given()
                .log().body()
                .header("Authorization", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZENoYW5nZSI6ZmFsc2UsInVzZXJfbmFtZSI6InJpY2hmaWVsZC5lZHUiLCJzY29wZSI6WyJvcGVuaWQiXSwiZXhwIjoxNjY1MDgyMzUyLCJpYXQiOjE2NjUwODIwNTIsImF1dGhvcml0aWVzIjpbIlJPTEVfRVZFUllPTkUiLCJST0xFX1RFTkFOVF9BRE1JTiJdLCJqdGkiOiJIU3JUWjhGOWJTdE9rZHB6bFZvekNrdEdfOG8iLCJjbGllbnRfaWQiOiJ3ZWJfYXBwIiwidXNlcm5hbWUiOiJyaWNoZmllbGQuZWR1In0.aFHQo4Pc6VHqgXyHJKZOHT6_fIUP399G2mraaaPeqOpJ6-PrdVP2CbhGeOf3Ydv7Z7KmOxTS3CAHyVSVod_SGzXuYeDWMxio7Nb8_TqyIfC7ktFUPUowG5eqAbpwtj7sLqb-9D5DNBWr_MjNXSxdfMey5iZaUGZMxpL434-NeuO6WmWWxXxRyQF-FeP6HYO-4Q7VYy2u_te8uHQpPZJR2jOYAo6upQ0teTjFGLps6Pg7rFVLyByP-QE0T48bj6Z9OagcCCj5-olzlSxXri_2gQOTLAkCRjJ1M82o2SV1wMS32M4n47eLBzd3DSHbOy6xQApGw5ChwZG9wdlnosJuyw")
                .contentType(ContentType.JSON);

        credentials = new HashMap<>();
        credentials.put("username", "richfield.edu");
        credentials.put("password", "Richfield2020!");
        credentials.put("rememberMe", "true");


        cookies = given()
                .spec(reqSpec)
                .body(credentials)
                .when()
                .post("/auth/login")
                .then()
                .log().body()
                .statusCode(200)
                .body("scope", equalTo("openid"))
                .extract().detailedCookies();
    }


    @Test (priority = 1)
    public void addAttestationTest() {

        user.setName("nigar");

        user.setId(given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(user)
                .when()
                .post("/school-service/api/attestation")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo(user.getName()))
                .extract().jsonPath().getString("id"));

    }


    @Test (priority = 2)

    public void addAttestationNegativeTest(){

        user.setName("nigar");

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(user)
                .when()
                .post("/school-service/api/attestation")
                .then()
                .log().body()
                .statusCode(400);

    }


    @Test (priority = 3)
    public void editAttestationTest(){

        HashMap<String, String> editReqBody = new HashMap<>();

        editReqBody.put("id", user.getId());
        editReqBody.put("name", "nasker");

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .body(editReqBody)
                .when()
                .put("/school-service/api/attestation")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo(editReqBody.get("name")));


    }

    @Test (priority = 4)
    public void deleteAttestationTest(){

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attestation/" + user.getId())
                .then()
                .log().body()
                .statusCode(204);

    }


    @Test (priority = 5)
    public void deleteAttestationNegativeTest(){

        given()
                .spec(reqSpec)
                .cookies(cookies)
                .when()
                .delete("/school-service/api/attestation/" + user.getId())
                .then()
                .log().body()
                .statusCode(400);
    }








}


