package objects;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersClassInfo implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println("test fails");
		
	}

}
