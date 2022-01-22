import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CalculatorTest {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args){
        try{
            openCalculator();

        }catch(Exception exp){
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }
    public static void openCalculator() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("deviceName","sdk_gphone_x86");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");

        cap.setCapability("appPackage","com.google.android.calculator");
        cap.setCapability("appActivity","com.android.calculator2.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AppiumDriver<MobileElement>(url, cap);

        System.out.println("Application Started....");

        MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
        MobileElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));

        two.click();
        plus.click();
        three.click();
        equals.click();

        MobileElement result = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView"));
        
        String res = result.getText();
        System.out.println("\n Result is : "+res);

        System.out.println("Exit");

    }
}
