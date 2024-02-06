package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class page_robocorp {

        private String pageUrl = "https://robocorp.com/";
        private String footerTextString = "Robocorp enables you to unlock the vast potential of generative AI and enterprise automation";
        private By footerTextLocator= By.xpath("//div[@class='site-footer__menu']//li//ul//a");
        public String getPageUrl() {
            return pageUrl;
        }

        public String getFooterTextString(){
            return footerTextString;
        }
        public int getFooterText(WebDriver driver) {
           return driver.findElements(footerTextLocator).size();
        }

}
