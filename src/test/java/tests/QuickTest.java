package tests;

import org.testng.annotations.Test;

public class QuickTest extends BaseTest{
    @Test(groups = {"web","rest"})
    public void smokeTest(){
        System.out.println("Im quick test");
    }
}
