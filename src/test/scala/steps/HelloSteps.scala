package steps

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers

class HelloSteps extends ScalaDsl with EN with Matchers {
  When("the test is invoked") { () =>
    println("when")
  }

  Then("the test should fail") { () =>
    println("then")
    true shouldBe false
  }
}
