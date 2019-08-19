package Practice.FrameworkAppium;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "InputData")
	public Object getDaataEditField() {
		Object[][] obj = new Object[][]
				{
			{"Hell"},{"!@#@$@"}
			
				};
			return obj;
		
	}
}
