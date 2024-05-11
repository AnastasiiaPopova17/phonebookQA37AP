package tests.api;

import dto.ContactDTOLombok;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class DeleteContactsTests extends BaseTestAPI{
    private String id = "";
    private String wrongId = "1";

    @BeforeMethod
    public void precondition() {
        Random random = new Random();
        String name = "John" + String.valueOf(random.nextInt(1000));
        String phone = String.valueOf(random.nextInt(10000)) + "456789";

        ContactDTOLombok contactDTOLombok = ContactDTOLombok.builder()
                .name(name)
                .lastName("Smith")
                .email("some@mail.com")
                .phone(phone)
                .address("street")
                .description("first")
                .build();

        String message = given()
                .header(AUTH, token)
                .body(contactDTOLombok)
                .contentType(ContentType.JSON)
                .post(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");
        System.out.println(message);
        String[] str = message.split(":");
        id = str[1].trim();
        System.out.println(id);
    }

    @Test
    public void deleteOneContactPositiveTest() {
    String message = given()
                .header(AUTH, token)
                .delete(ENDPOINT_CONTACTS + "/" + id)
                .then()
                .assertThat().statusCode(200)
            .extract().path("message");
        System.out.println("delete contact " + message);
    }

    @Test
    public void deleteOneContactErrorTest() {
        String message = given()
                .header(AUTH, token)
                .delete(ENDPOINT_CONTACTS + "/" + wrongId)
                .then()
                .assertThat().statusCode(400)
                .extract().path("message");
        System.out.println("delete contact " + message);
    }

    @Test
    public void deleteOneContactNegativeTest() {
        given()
                .header(AUTH, TOKEN2)
                .delete(ENDPOINT_CONTACTS + "/" + id)
                .then()
                .assertThat().statusCode(401);
    }
}
