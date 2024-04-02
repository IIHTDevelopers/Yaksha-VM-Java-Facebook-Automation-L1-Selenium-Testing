package testBase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import coreUtilities.testbase.TestBase;

public class AppTestBase extends TestBase {
	public static final Logger logger = LogManager.getLogger();
	
	public String projectBaseDirPath = System.getProperty("user.dir");
	public String config_filePath = projectBaseDirPath+"/src/main/resources/config.json";
	public String testDataFilePath = projectBaseDirPath+"/src/test/java/testdata/";
	public String db_filepath=projectBaseDirPath+"/src/main/resources/db_config.json";
	
	public SoftAssert softAssert;

}
