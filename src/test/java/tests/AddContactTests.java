
package tests;

import dto.ContactDTO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

import java.util.Random;

public class AddContactTests extends tests.BaseTest {

    @BeforeClass
    public void preconditions() {
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(user);
    }

    @AfterClass
    public void methodPostCondition() {
        app.getUserHelper().clickLogoutBtn();
        app.getHomePageHelper().navigateToHomePage();
    }

    @Test
    public void positiveAddContact() {
        Random random = new Random();
        String name = "John" + String.valueOf(random.nextInt(1000));
        String phone = String.valueOf(random.nextInt(10000)) + "456789";
        //String phone2 = String.valueOf(random.nextLong(1000000000L));

        app.getContactHelper().clickAddOnNavBar();
        ContactDTO contactDTO = new ContactDTO()
                .setName("poiuy")
                .setLastName("jhsbfh")
                .setPhone("5554567890")
                .setEmail("proba@mail.com")
                .setAddress("hjsbfhb")
                .setDescription("bhjfdb");
        app.getContactHelper().addContact(contactDTO);

        app.getContactHelper().pause(3000);

        Assert.assertTrue(app.getContactHelper().isContactDisplaysOnThePage("5554567890"));
    }


    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void positiveAddContactProvider(String name,String lastName,String phone,
                                           String email,String address,String description)
    {
        app.getContactHelper().clickAddOnNavBar();
        ContactDTO contactDTO = new ContactDTO()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description);
        app.getContactHelper().addContact(contactDTO);

        app.getContactHelper().pause(2000);

        Assert.assertTrue(app.getContactHelper().isContactDisplaysOnThePage("5554567890"));
    }
    @Test(dataProvider = "addContactCSVFile", dataProviderClass = DataProviders.class)
    public void positiveAddContactProviderCSV (ContactDTO contactDTO)
    {
        app.getContactHelper().clickAddOnNavBar();

        app.getContactHelper().addContact(contactDTO);

        app.getContactHelper().pause(2000);

        Assert.assertTrue(app.getContactHelper().isContactDisplaysOnThePage("5554567890"));
    }

}
