package tests;

import org.testng.annotations.Test;

public class QuickTestBase extends TestBase {
    @Test(groups = {"web","rest"})
    public void smokeTest(){
        System.out.println("Im quick test");
    }
}
