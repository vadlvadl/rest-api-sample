
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestUserLogin {

    @BeforeTest
    public void setup(){
        RestAssured.baseURI = "http://jira.hillel.it";
        RestAssured.port = 8080;
    }


    @Test
    public void login(){

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();

        requestParams.put("username","webinar5");
        requestParams.put("password","webinar5");

        request.header("Content-Type", "application/json");

        request.body(requestParams.toString());

        Response response = request.post("/rest/auth/1/session");


        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String JSESSIONID = response.jsonPath().get("session.value");
        System.out.println(JSESSIONID);

        SessionClass session = response.getBody().as(SessionClass.class);

        System.out.println("Session ID: " + session.getSessionID());
//        System.out.println(response.body().asString());

//        given()
//                .queryParam("username","webinar5")
//                .queryParam("password","webinar5")
//                .contentType("application/json")
//                .post("http://jira.hillel.it:8080/rest/auth/1/session").then().log().all();
    }
}
