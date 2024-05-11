package tests.api;

import dto.ContactDTOLombok;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class AddNewContactTests extends BaseTestAPI{
    @Test(description = "add one contact positive test")
    public void addContactPositiveTest() {
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
    }
}
