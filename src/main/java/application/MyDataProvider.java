package application;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
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
        while(line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
