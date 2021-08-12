package application;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> validLoginDataClassDP() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"skelon+4@bk.ru", "Qwerty$4"});
        list.add(new Object[]{"skelon+11@bk.ru", "Qwerty$4"});
        list.add(new Object[]{"skelon+10@bk.ru", "Qwerty$4"});

        return list.iterator();
    }

    //======================================with data csv
    @DataProvider
    public Iterator<Object[]> dataFileCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    //=========================================ADD Contacts
    @DataProvider
    public Iterator<Object[]> dataContactCSV() throws IOException {

        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataContacts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");

            list.add(new Object[]{Contact.builder()
                    .name(split[0])
                    .lastName(split[1])
                    .phone(split[2])
                    .email(split[3])
                    .address(split[4])
                    .description(split[5])
                    .build()});

            line = reader.readLine();
        }
        return list.iterator();
    }
    //======================================================
    @DataProvider
    public Iterator<Object[]> DataContactDP() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{"Masha","Qwerty","1234512678","kselon01@bk.ru","Haifa","friend"});
        list.add(new Object[]{"Sasha","Asdfgh","9872115632","kselon02@bk.ru","Haifa","friend"});
        list.add(new Object[]{"Mosha","wrnaertn","1211567412","kselon03@bk.ru","Haifa","friend"});

        return list.iterator();
    }
}
