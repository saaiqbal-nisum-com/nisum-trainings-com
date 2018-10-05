package utilities;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestDriver;

public class Utils extends TestDriver{
	
public static String CaptureScreen(WebDriver driver){
	System.out.println("In new screenshot------------");
    TakesScreenshot newScreen = (TakesScreenshot) driver;
    String scnShot = newScreen.getScreenshotAs(OutputType.BASE64);
    return "data:image/png;base64, " + scnShot ;
	}

}
