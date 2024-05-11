package tests.api;

import dto.UserDTOLombok;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTestAPI {
    UserDTOLombok userAPI = UserDTOLombok.builder()
            .username("proba@gmail.com")
            .password("1234Qwer!")
            .build();

    public static final String TOKEN1 = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicHJvYmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE";
    public static final String TOKEN2 = "hbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoicHJvYmFAZ21haWwuY29tIiwiaXNzIjoiUmVndWxhaXQiLCJleHAiOjE";
    public String token = "";
    public static final String AUTH = "Authorization";
    public static final String ENDPOINT_LOGIN = "/user/login/usernamepassword";
    public static final String ENDPOINT_CONTACTS = "/contacts";


    @BeforeSuite
    public void initAPI() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "/v1";
        token = requestLoginApi(userAPI).then().extract().path("token");
    }

    public Response requestLoginApi(UserDTOLombok user) {
        return  given()
                .body(user)
                .when()
                .post(ENDPOINT_LOGIN);
    }
}
