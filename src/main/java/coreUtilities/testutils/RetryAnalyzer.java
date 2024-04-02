package coreUtilities.testutils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	int count=0;
	int maxRetryLimit = 0;

	@Override
	public boolean retry(ITestResult result) {
		
		if(count<maxRetryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}