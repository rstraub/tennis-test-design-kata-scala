package steps

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers

class HelloSteps extends ScalaDsl with EN with Matchers {
  When("the test is invoked") {
    print("when")
  }

  Then("the test should fail") {
    print("then")
  }
}
