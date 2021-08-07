package tests;

import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {
    @Test(groups = {"web"})
    public void smokeTest() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Im smoke test");
    }
}
