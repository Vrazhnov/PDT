package ru.qa.aet;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VesselCreationTests {

    public class LoginGo2vesselTestng {
        private WebDriver driver;
        private String baseUrl;
        private boolean acceptNextAlert = true;
        private StringBuffer verificationErrors = new StringBuffer();

        @BeforeClass(alwaysRun = true)
        public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://tos2.solvo.ru:33080/aet/login.xhtml";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        @Test
        public void testLoginGo2vesselTestng() throws Exception {
            driver.get(baseUrl + "/aet/login.xhtml");
            driver.findElement(By.id("LoginForm:userid")).clear();
            driver.findElement(By.id("LoginForm:userid")).sendKeys("ALENAW");
            driver.findElement(By.id("LoginForm:password")).clear();
            driver.findElement(By.id("LoginForm:password")).sendKeys("123");
            driver.findElement(By.id("LoginForm:loginButton")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.cssSelector("a.ripplelink > span"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.xpath("//li[@id='menuform:j_idt39_9']/a/span")).click();
            driver.findElement(By.linkText("Vessels")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("vessel:RefVesselToolbarForm:createButton"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.id("vessel:RefVesselToolbarForm:createButton")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.xpath("//span[@id='VesselEditForm:display']/div[2]"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.id("VesselEditForm:name")).clear();
            driver.findElement(By.id("VesselEditForm:name")).sendKeys("ROM1");
            driver.findElement(By.id("VesselEditForm:originalName")).clear();
            driver.findElement(By.id("VesselEditForm:originalName")).sendKeys("LOCROM1");
            driver.findElement(By.id("VesselEditForm:callsign")).clear();
            driver.findElement(By.id("VesselEditForm:callsign")).sendKeys("ROMC1");
            driver.findElement(By.id("VesselEditForm:imoCode")).clear();
            driver.findElement(By.id("VesselEditForm:imoCode")).sendKeys("1111");
            driver.findElement(By.id("VesselEditForm:mmsiCode")).clear();
            driver.findElement(By.id("VesselEditForm:mmsiCode")).sendKeys("4545");
            driver.findElement(By.id("VesselEditForm:vesselFlag:vesselFlagSearchBtn")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (driver.findElement(By.cssSelector("span.country.CO")).isDisplayed()) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.cssSelector("span.country.CO")).click();
            assertEquals(driver.findElement(By.id("VesselEditForm:vesselFlag:ac_input")).getAttribute("value"), "COLOMBIA");
            driver.findElement(By.id("VesselEditForm:portRegistration:portRegistrationSearchBtn")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("PortHelper_datalist:PortHelperListForm:datalist"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.id("PortHelper_datalist:PortHelperListForm:datalist:4:portCodeOutput")).click();
            driver.findElement(By.id("VesselEditForm:yearBuild_input")).clear();
            driver.findElement(By.id("VesselEditForm:yearBuild_input")).sendKeys("2005");
            driver.findElement(By.id("VesselEditForm:shipLine:shipLineSearchBtn")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("StakeholderHelper_datalist:StakeholderHelperListForm:datalist:0:shortNameOutput"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.id("StakeholderHelper_datalist:StakeholderHelperListForm:datalist:0:shortNameOutput")).click();
            driver.findElement(By.id("VesselEditForm:length_input")).clear();
            driver.findElement(By.id("VesselEditForm:length_input")).sendKeys("79");
            driver.findElement(By.id("VesselEditForm:width_input")).clear();
            driver.findElement(By.id("VesselEditForm:width_input")).sendKeys("15");
            driver.findElement(By.id("VesselEditForm:draughtMax_input")).clear();
            driver.findElement(By.id("VesselEditForm:draughtMax_input")).sendKeys("3");
            driver.findElement(By.id("VesselEditForm:depthMoulded_input")).clear();
            driver.findElement(By.id("VesselEditForm:depthMoulded_input")).sendKeys("15");
            driver.findElement(By.id("VesselEditForm:craneMaxWeight_input")).clear();
            driver.findElement(By.id("VesselEditForm:craneMaxWeight_input")).sendKeys("5");
            driver.findElement(By.id("VesselEditForm:bruttoRegTonnes_input")).clear();
            driver.findElement(By.id("VesselEditForm:bruttoRegTonnes_input")).sendKeys("25");
            driver.findElement(By.id("VesselEditForm:nettoRegTonnes_input")).clear();
            driver.findElement(By.id("VesselEditForm:nettoRegTonnes_input")).sendKeys("25");
            driver.findElement(By.id("VesselEditForm:deadWeight_input")).clear();
            driver.findElement(By.id("VesselEditForm:deadWeight_input")).sendKeys("2");
            driver.findElement(By.id("VesselEditForm:maxTeu_input")).clear();
            driver.findElement(By.id("VesselEditForm:maxTeu_input")).sendKeys("99");
            driver.findElement(By.id("VesselEditForm:cargoAirDraft_input")).clear();
            driver.findElement(By.id("VesselEditForm:cargoAirDraft_input")).sendKeys("10");
            driver.findElement(By.id("VesselEditForm:tierMax_input")).clear();
            driver.findElement(By.id("VesselEditForm:tierMax_input")).sendKeys("5");
            driver.findElement(By.id("VesselEditForm:bayMax_input")).clear();
            driver.findElement(By.id("VesselEditForm:bayMax_input")).sendKeys("3");
            driver.findElement(By.id("VesselEditForm:rampDescr")).clear();
            driver.findElement(By.id("VesselEditForm:rampDescr")).sendKeys("5");
            driver.findElement(By.id("VesselEditForm:hatchesDescr")).clear();
            driver.findElement(By.id("VesselEditForm:hatchesDescr")).sendKeys("5");
            driver.findElement(By.id("VesselEditForm:hatchWeight_input")).clear();
            driver.findElement(By.id("VesselEditForm:hatchWeight_input")).sendKeys("5");
            driver.findElement(By.id("VesselEditForm:craneDescr")).clear();
            driver.findElement(By.id("VesselEditForm:craneDescr")).sendKeys("3");
            driver.findElement(By.id("VesselEditForm:comments")).clear();
            driver.findElement(By.id("VesselEditForm:comments")).sendKeys("comments");
            driver.findElement(By.id("VesselEditForm:externalUrl")).clear();
            driver.findElement(By.id("VesselEditForm:externalUrl")).sendKeys("external ref");
            driver.findElement(By.id("VesselEditForm:cargoPlanProcess")).clear();
            driver.findElement(By.id("VesselEditForm:cargoPlanProcess")).sendKeys("container");
            driver.findElement(By.id("VesselEditForm:editSaveBtn")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("vessel:RefVesselListForm:centerPane"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            driver.findElement(By.cssSelector("span[title=\"#\"]")).click();
            driver.findElement(By.xpath("//th[@id='vessel:RefVesselListForm:datalist:j_id2']/span[3]")).click();
            for (int second = 0;; second++) {
                if (second >= 60) fail("timeout");
                try { if (isElementPresent(By.id("vessel:RefVesselListForm:datalist:0:nameOutput"))) break; } catch (Exception e) {}
                Thread.sleep(1000);
            }

            assertEquals(driver.findElement(By.id("vessel:RefVesselListForm:datalist:0:nameOutput")).getText(), "ROM1");
        }

        @AfterClass(alwaysRun = true)
        public void tearDown() throws Exception {
            driver.quit();
            String verificationErrorString = verificationErrors.toString();
            if (!"".equals(verificationErrorString)) {
                fail(verificationErrorString);
            }
        }

        private boolean isElementPresent(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

        private boolean isAlertPresent() {
            try {
                driver.switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                return false;
            }
        }

        private String closeAlertAndGetItsText() {
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }
    }

}
