package tests.api;

import dto.AllContactsDTO;
import dto.ContactDTOLombok;
import dto.UserDTOLombok;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllContactsTests extends BaseTestAPI {


    @Test(description = "positive get all contacts test")
    public void getAllContactsTest() {
        AllContactsDTO allContactsDTO = given()
                .header(AUTH, token)
                .when()
                .get(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDTO.class);
        System.out.println(allContactsDTO.getContacts().get(0).getId());
        List<ContactDTOLombok> allContacts = allContactsDTO.getContacts();
        for (ContactDTOLombok contact: allContacts) {
            System.out.println("id: " + contact.getId() +
                    " name: " + contact.getName());
        }
    }

    @Test(description = "negative unAuthorization test")
    public void unAuthorizedGetAllContactsTest() {
                given()
                .header(AUTH, TOKEN2)
                .when()
                .get(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(401);
    }

    @Test(description = "negative error test")
    public void errorGetAllContactsTest() {
        given()
                .body(userAPI)
                .when()
                .get(ENDPOINT_CONTACTS)
                .then()
                .assertThat().statusCode(403);
    }
}
