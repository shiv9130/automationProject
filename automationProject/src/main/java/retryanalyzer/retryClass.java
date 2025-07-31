package retryanalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryClass implements IRetryAnalyzer{//my test again through retry class

	
	int current_count=0;
	int retry_count =1;
	public boolean retry(ITestResult result) {
		if(current_count<retry_count) {
		     current_count++;
		return true;
	
		}else {
			return false;
		}
		
	}

}
