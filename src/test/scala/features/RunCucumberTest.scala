package features

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  glue = Array("features"),
  plugin = Array("pretty")
)
class RunCucumberTest {}
