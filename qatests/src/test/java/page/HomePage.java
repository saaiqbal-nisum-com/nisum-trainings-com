package page;
import org.openqa.selenium.By;
import base.TestDriver;

public class HomePage extends TestDriver{
	public final By sum_button = By.cssSelector("input[type='button']");
	public final By input1 = By.id("n1");
	public final By input2 = By.id("n2");
	public final By textmsg = By.id("result");
	
}
