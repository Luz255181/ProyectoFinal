package testRunner_Demoblaze;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\java\\Demoblaze"}, glue = {"Demoblaze"}, plugin = {"progress"}, monochrome = true)

public class TestRunner {

}
