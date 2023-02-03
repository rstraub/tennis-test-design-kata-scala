package steps

import org.junit.platform.suite.api.{ConfigurationParameter, IncludeEngines, SelectClasspathResource, Suite}
import io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME
import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME

@Suite
@IncludeEngines(Array("cucumber"))
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")
class CucumberRunner {}
