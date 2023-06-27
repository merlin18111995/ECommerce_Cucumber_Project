package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)  
@CucumberOptions(
		//features = {".//Features//LoginDDExcel.feature"},
		//features = {".//Features//Login.feature",".//Features//LoginDD.feature"},  //we can run multiple features
		//features = {".//Features"}, //all feature files will be execued
		features = {".//Features//Login.feature"},
		//features = "@target/rerun.txt",
		glue = "stepDefenitions",
		plugin = {"pretty","html:reports/myreport.html","json:reports/myreport.json","rerun:target/rerun.txt"},
		dryRun=false,  //by default its false, when its true, it will only check whether all 
					//	steps are implemented in methods or not
		monochrome=true , //it will remove unneccasry comments from console
		tags= "@Sanity" //if any scenario is added with sanity tag [same scenario can have multiple tags]
		//tags= "@Regression" //if any scenario is added with regression tag [same scenario can have multiple tags]
		//tags= "@Sanity and @Regression" //if any scenario is added with both the tags
		//tags= "@Sanity or @Regression"  //if any scenario is added with any of the tags 
		//tags= "@Sanity and not @Regression"  //if any scenario is added with only sanity tag
		)
public class TestRunner {

}
