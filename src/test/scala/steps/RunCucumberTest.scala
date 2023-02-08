package steps

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  glue = Array("steps"),
  features = Array("classpath:features"),
  plugin = Array("pretty")
)
class RunCucumberTest {}
