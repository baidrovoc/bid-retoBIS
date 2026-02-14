package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/fatca-certificado.feature",
        glue = {"stepdefinitions", "hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@testfeature"
)
public class RunnerBanistmo {
}
