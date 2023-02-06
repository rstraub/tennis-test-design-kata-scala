package steps

import io.cucumber.junit.platform.engine.Constants.{
  GLUE_PROPERTY_NAME,
  PLUGIN_PROPERTY_NAME
}
import org.junit.platform.suite.api.{
  ConfigurationParameter,
  IncludeEngines,
  SelectClasspathResource,
  Suite
}

@Suite
@IncludeEngines(Array("cucumber"))
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
class CucumberRunner {}
