package RsComponents;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/RsComponents/Features/",

        tags = {"@Regression"},
        // tags={"@checkout1"},


        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"})



public class TestRunner {



}
