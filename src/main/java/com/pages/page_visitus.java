package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class page_visitus {

    private String pageUrl = "https://robocorp.com/docs";
    private By footerTextLocator= By.xpath("//footer//a");
    public String getPageUrl() {
        return pageUrl;
    }

    public int getFooterText(WebDriver driver) {
        return driver.findElements(footerTextLocator).size();
    }

}
