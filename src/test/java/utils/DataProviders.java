package utils;

import dto.ContactDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> addNewContact() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Asya", "Smith", "1234567890", "some@mail.com", "Hamburg", "friend"});
        list.add(new Object[]{"Vasya", "Smith", "1234567891", "some@mail.com", "Hamburg", "friend"});
        list.add(new Object[]{"Asya", "Bond", "1234567892", "some@mail.com", "Hamburg", "friend"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> addContactCSVFile() {
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/contacts.csv")));
            line = reader.readLine();

            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new ContactDTO().setName(split[0]).setLastName(split[1]).setPhone(split[2]).setEmail(split[3])
                        .setAddress(split[4]).setDescription(split[5])});
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
