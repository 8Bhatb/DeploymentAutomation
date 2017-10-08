
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

 
public class deployConfiguration {
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Actions actions;
	public String[][] commands;

	public deployConfiguration(String[][] commands) {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		LoggingPreferences pref = new LoggingPreferences();
		pref.enable(LogType.BROWSER, Level.OFF);
		pref.enable(LogType.CLIENT, Level.OFF);
		pref.enable(LogType.DRIVER, Level.OFF);
		pref.enable(LogType.PERFORMANCE, Level.OFF);
		pref.enable(LogType.PROFILER, Level.OFF);
		pref.enable(LogType.SERVER, Level.OFF);

		//DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		//desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, pref);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--log-level=3");
		driver = new ChromeDriver(options);
		//driver = new FirefoxDriver();
		jse = (JavascriptExecutor)driver;
		actions = new Actions(driver);
		this.commands = commands;
		processCommands();
		
	}
	
	public void processCommands() {
		for (int i=0;i<commands.length;i++) {
			String cmdNo = commands[i][0];
			String action = commands[i][1];
			String detail = commands[i][2];
			String value = commands[i][3];
			
			o("***Processing command :"+i+":"+cmdNo+" : "+action+">"+detail+">"+value);

			try {
				switch(action.toLowerCase()) {
				case "go to page":
					processGoToPage(cmdNo, detail, value, commands[i]);
					break;
				case "set value":
					processSetValue(cmdNo,detail,value, commands[i]);
					break;
				case "click":
					processClick(cmdNo,detail,value, commands[i]);
					break;
				case "show me":
					processShowMe(cmdNo,detail,value, commands[i]);
					break;
				case "verify if present":
					processVerifyIfPresent(cmdNo,detail,value, commands[i]);
					break;
				case "verify value":
					processVerifyValue(cmdNo,detail,value, commands[i]);
					break;
				case "append value":
					processSetValue(cmdNo,detail,value, commands[i]);
					break;
				case "clear":
					processClear(cmdNo,detail,value, commands[i]);
					break;
				case "select":
					//TODO
					processSelect(cmdNo,detail,value, commands[i]);
					break;
				case "pass test":
					processPassTest(cmdNo,detail,value, commands[i]);
					break;
				case "scroll to end":
					processScrollToEnd(cmdNo,detail,value, commands[i]);
					break;
				case "scroll to top":
					processScrollToTop(cmdNo,detail,value, commands[i]);
					break;
				case "scroll by":
					processScrollBy(cmdNo,detail,value, commands[i]);
					break;
				default:
					break;
				}
			} catch (Exception e) {
				o(e.getMessage());
				return;
			}
		}
		
	}

	private void processSelect(String cmdNo, String detail, String value, String[] strings) throws Exception {
		// TODO Auto-generated method stub
		try {
			//((WebElement) getElement(detail));
		}
		catch (Exception e) {
			stop(cmdNo, "Clear", detail, value, e);
		}
	}

	private void processClear(String cmdNo, String detail, String value, String[] strings) throws Exception {
		// TODO Auto-generated method stub
		try {
			((WebElement) getElement(detail)).clear();
		}
		catch (Exception e) {
			stop(cmdNo, "Clear", detail, value, e);
		}
		
	}

	private void processScrollBy(String cmdNo, String detail, String value, String[] strings) {
		// TODO Auto-generated method stub
		jse.executeScript("window.scrollBy(0,"+detail+")", "");
		
	}

	private void processScrollToEnd(String cmdNo, String detail, String value, String[] strings) {
		// TODO Auto-generated method stub
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");
	}
	
	private void processScrollToTop(String cmdNo, String detail, String value, String[] strings) {
		// TODO Auto-generated method stub
		jse.executeScript("window.scrollTo(0,0)", "");
	}

	private void processPassTest(String cmdNo, String detail, String value, String[] strings) {
		// TODO Auto-generated method stub
		
	}

	private void processVerifyValue(String cmdNo, String detail, String value, String[] strings) throws Exception {
		// TODO Auto-generated method stub
		try {
			WebElement e = getElement(detail);
			if(e.getText()!=value)
					stop(cmdNo, "Verify value", detail, value,
							new Exception("Value doesnt match :Expecting>"+value+"| Found>"+e.getText()) );
			
			}
			catch (Exception e) {
				stop(cmdNo, "Verify value", detail, value, e );
			}
	}
	
	private void processVerifyIfPresent(String cmdNo, String detail, String value, String[] strings) throws Exception {
		// TODO Auto-generated method stub
		try {
			WebElement e = getElement(detail);
		}
		catch (Exception e) {
			stop(cmdNo, "Verify if present", detail, value, e );
		}
	}


	private void processShowMe(String cmdNo, String detail, String value, String[] strings) {
		// TODO Auto-generated method stub

		try {
			driver.get(url(detail));
			Thread.sleep(2000);

			//driver.getWindowHandle()
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("D:\\screenshot.png"));
			
		} catch (Exception e) {
			try {
				stop(cmdNo, "Show me",detail, value, e );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	private String url(String detail) {
		// TODO Auto-generated method stub
		String pageUrl="";
		if(detail.startsWith("http")) {
			pageUrl=detail;
		}
		else {
			URL url=null;
			try {
				url = new URL(driver.getCurrentUrl());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pageUrl = url.getProtocol()+"://"+url.getHost() + detail;
		}
		return pageUrl;
	}

	private void processClick(String cmdNo, String detail, String value, String[] strings) throws Exception {
		// TODO Auto-generated method stub
		try {
			((WebElement)getElement(detail)).click();
			//WebElement element = getElement(detail);
			//jse.executeScript("console.log(arguments[0])", element);
			//jse.executeScript("arguments[0].click();", element);
		}
		catch (Exception e) {
			stop(cmdNo, "Click", detail, value, e );
		}
	}
	private void processSetValue(String cmdNo, String detail, String value, String[] command) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			((WebElement)getElement(detail)).sendKeys(value);
		}
		catch(Exception e) {
			stop(cmdNo, "Set Value",detail, value, e );
		}
		
	}

	@SuppressWarnings("deprecation")
	private void processGoToPage(String cmdNo, String detail, String value,String [] command) throws Exception {
		// open the page and sleep for 2 sec
		try {
			driver.get(url(detail));
			Thread.sleep(2000);
			File f = new File("D:\\load.txt");
			FileUtils.write(f, driver.getPageSource());
		} catch (InterruptedException e) {
			stop(cmdNo, "Go to page",detail, value, e );
		}
	}

	public void o(Object out) {
		System.out.println(out); 
	
	}
	
	public void stop(String cmdNo, String action, String detail, String value, Exception e) throws Exception {
		//e.printStackTrace();
		o("***Command failed "+cmdNo+" : "+action+">"+detail+">"+value+">"+e.getMessage());
		throw new Exception("Command failed:");
	}	
	
	private WebElement getElement(String detail) {
		WebElement element = null;
		try {
			String identifier = detail.substring(0,detail.indexOf("="));
			String subValue = detail.substring(detail.indexOf("=")+1);
			switch(identifier) {
			case "id": 
				element = driver.findElement(By.id(subValue));
				//o("count of "+detail+" is "+driver.findElements(By.id(subValue)).size());
				break;
			case "name": 
				element = driver.findElement(By.name(subValue));
				break;
			case "xpath": 
				element = driver.findElement(By.xpath(subValue));
				break;
			}
		}
		catch (Exception e) {
			throw e;
		}
		actions.moveToElement(element).perform();
		//o("element "+detail+" is displayed: "+element.isDisplayed());
		//o("element "+detail+" is enabled: "+element.isEnabled());
		//o("element "+detail+" is selected: "+element.isSelected());
		return element;
	}
}
