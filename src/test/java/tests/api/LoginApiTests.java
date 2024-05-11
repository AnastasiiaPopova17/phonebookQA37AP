package tests.api;

import dto.ErrorDTO;
import dto.UserDTOLombok;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTests extends BaseTestAPI {


    @Test(description = "assert status code 200 for positive login")
    public void positiveLoginTestStatusCode() {
                requestLoginApi(userAPI)
                .then()
                .assertThat().statusCode(200);
    }

    @Test(description = "assert we get for positive login")
    public void positiveLoginTestToken() {
        String pathToken = given()
                .body(userAPI)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .body(Matchers.containsString("token"))
                .extract().path("token");
        System.out.println(pathToken);
    }

    @Test(description = "negative login test - wrong email")
    public void negativeLoginTestWrongEmail() {
        UserDTOLombok userWrongEmail = UserDTOLombok.builder()
                .username("probka@gmail.com")
                .password("1234Qwer!")
                .build();

        given()
                .body(userWrongEmail)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .assertThat().statusCode(401);
    }

    @Test(description = "negative login test - wrong password")
    public void negativeLoginTestWrongPasswrd() {
        UserDTOLombok userWrongEmail = UserDTOLombok.builder()
                .username("proba@gmail.com")
                .password("123Qwer!")
                .build();

        ErrorDTO errorDTO = given()
                .body(userWrongEmail)
                .when()
                .post(ENDPOINT_LOGIN)
                .then()
                .assertThat().statusCode(401)
                .assertThat().body("error",equalTo("Unauthorized"))
                .assertThat().body("message",equalTo("Login or Password incorrect"))
                .assertThat().body("status",equalTo(401))
                .extract().response().as(ErrorDTO.class);
        System.out.println(errorDTO.getMessage());
        System.out.println(errorDTO.getStatus());
        System.out.println(errorDTO.getError());
    }
}
