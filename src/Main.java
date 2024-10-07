import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Thiết lập ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/Users/alive/Documents/Khoa/TestProgram/chromedriver-mac-x64/chromedriver");
        //System.setProperty("webdriver.chrome.driver", "D:\\04 - Windows Software\\chromedriver-win64\\chromedriver.exe");

        //Test push git branch develop

        //Khoi tao ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); //open full width
        driver.get("https://nagoya-meieki-hidamarikokoro.jp/");
        Thread.sleep(3000);

        // Lấy tất cả thẻ <a> trên trang
        List<WebElement> totallinks = driver.findElements(By.tagName("a"));
        System.out.println("Tổng số link là: " + totallinks.size());
        for (WebElement ele : totallinks)
        {
            System.out.println(ele.getText() + "||" + ele.getAttribute("href"));
        }
        //Mở toàn bộ link trong site
//        for (WebElement link : totallinks) {
//            String href = link.getAttribute("href");
//            String linkText = link.getText();
//            if (href != null && !href.isEmpty()) {
//                try {
//                    // Sử dụng tổ hợp phím để mở tab mới (COMMAND + ENTER cho MacOS)
//                    String keyboard = Keys.chord(Keys.COMMAND, Keys.ENTER);
//                    link.sendKeys(keyboard);
//                    System.out.println("Mở link: " + linkText + " || " + href);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //Chỉ mở được link trong header -> k hiểu tại sao
        //WebElement links = driver.findElements(By.xpath("//*[@id='et-main-area']"));
//        WebElement links = driver.findElement(By.xpath("//*[@id='top']"));
//
//        try {
//            for (int i=0; i<totallinks.size(); i++)
//            {
//                //String keyboard = Keys.chord(Keys.CONTROL, Keys.ENTER); //Window
//                String keyboard = Keys.chord(Keys.COMMAND, Keys.ENTER); //IOS
//                totallinks.get(i).sendKeys(keyboard);
//                String linktext = totallinks.get(i).getText();
//                System.out.println(linktext);
//            }
//        }
//        catch(Exception e) {}

        // Tìm phần tử footer với class "footer js-footer"

        //Đây là phần tử HTML đại diện cho thẻ <footer> có class là "footer js-footer"
        WebElement footer = driver.findElement(By.cssSelector(".footer.js-footer"));

        // Tìm tất cả các thẻ <a> trong footer
        List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
        System.out.println("Tổng số link trong footer: " + footerLinks.size());

        // Lưu trữ tất cả các href và text của các liên kết vào một danh sách
        List<String> hrefList = new ArrayList<>();
        List<String> linkTextList = new ArrayList<>();

        //Mở toàn bộ link trong footer - Cách 1
        for (WebElement link : footerLinks) {
            String href = link.getAttribute("href");
            String linkText = link.getText();
            if (href != null && !href.isEmpty()) {
                try {
                    //String keyboard = Keys.chord(Keys.COMMAND, Keys.ENTER);
                    // Sử dụng tổ hợp phím để mở tab  mới (COMMAND + ENTER cho MacOS)
                    String keyboard = Keys.chord(Keys.COMMAND, Keys.ENTER);

                    // Sử dụng tổ hợp phím để mở tab mới (CONTROL + ENTER cho Windows)
                    //String keyboard = Keys.chord(Keys.CONTROL, Keys.ENTER);
                    link.sendKeys(keyboard);
                    System.out.println("Mở link: " + linkText + " || " + href);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        //Mở toàn bộ link trong footer - Cách 2
        // Chỉ thêm các liên kết có href không null hoặc trống
//            if (href != null && !href.isEmpty()) {
//                hrefList.add(href);
//                linkTextList.add(linkText);
//            }

        // Sau khi thu thập xong, thực hiện mở từng liên kết trong tab mới
//        try {
//            for (int i = 0; i < hrefList.size(); i++) {
//                String keyboard = Keys.chord(Keys.COMMAND, Keys.ENTER); // MacOS dùng COMMAND
//                driver.findElement(By.linkText(linkTextList.get(i))).sendKeys(keyboard);
//                System.out.println("Mở link: " + linkTextList.get(i) + " || " + hrefList.get(i));
//                Thread.sleep(1000);  // Đợi 1 giây giữa mỗi lần mở để tránh lỗi
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }



    }
}
