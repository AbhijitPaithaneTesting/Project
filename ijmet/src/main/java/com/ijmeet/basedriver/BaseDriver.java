package com.ijmeet.basedriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ijmeet.utility.GeneralUtil;

public class BaseDriver {
	public WebDriver driver;

	protected void startChrome() {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--windows-size=1600X1900");
		System.setProperty("webdriver.chrome.driver",
				getCurrentDirectory() + File.separator + "drivers" + File.separator + "chromeDriver.exe");
		// options.addArguments("--headless"); //if we want ghost or no ui

		ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
		int port = chromeDriverService.getUrl().getPort();
		// Log.info("Port use by Chrome driver" + port);
		driver = new ChromeDriver(chromeDriverService, options);
		driver.manage().window().setSize(new Dimension(1600, 1900));
	}

	/**
	 * @author Abhijit Paithane get current Working
	 * 
	 * @return current working Dir
	 * 
	 * 
	 *         this method can be used to get current working project dir to access
	 *         differernt folders
	 */
	private String getCurrentDirectory() {
		// TODO Auto-generated method stub
		String dirStr = null;
		try {
			File curDir = new File(".");
			dirStr = curDir.getCanonicalPath();
		} catch (IOException e) {
			// TODO: handle exception
			// Log.info("ERROR while trying to get current directory " + e);
		}
		return dirStr;
	}

	public String getSource() {
		return driver.getPageSource();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void afterClass() {
		try {
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			// TODO: handle exception
			// Log.debug("Error" + e);

		}
		KillChrome();
	}

	private void KillChrome() {
		// TODO Auto-generated method stub
		GeneralUtil.killProcess("ChromeDriver.exe");
		Sleep(1);
		GeneralUtil.killProcess("Chrome.exe");
		Sleep(1);
		try {
			Runtime.getRuntime().exec(
					"cmd /c del /q /s /f C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\Chrome\\User Data\\Defaults\\Cache\\*.*");

			Runtime.getRuntime().exec(
					"cmd /c del /q /s /f C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\Chrome\\User Data\\Defaults\\*Cookies*.*");

			Runtime.getRuntime().exec(
					"cmd /c del /q /s /f C:\\Users\\%USERNAME%\\AppData\\Local\\Google\\Chrome\\User Data\\Defaults\\C*History*.*");
		} catch (Exception e) {
			// TODO: handle exception
			//Log.debug("ERROR" + e);
		}
	}
	
	
	
	private void Sleep(int timeout) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(timeout * 1000L);
		} catch (InterruptedException e) {
			// TODO: handle exception
			//Log.debug("ERROR" + e);
			Thread.currentThread().interrupt();
		}
	}

	public void navigate(String url) {
		driver.get(url);
	}

	public void setActive() {
		String winHandleBefore = driver.getWindowHandle();
		if (!driver.getWindowHandle().isEmpty()) {
			driver.switchTo().window(winHandleBefore);
		}
	}

}
