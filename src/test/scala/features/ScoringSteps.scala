package features

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers

class ScoringSteps extends ScalaDsl with EN with Matchers {
  Given("""the points scored are""") { (points: DataTable) =>
    val playerOne = points.cell(1, 0)
    val playerTwo = points.cell(1, 1)
    println(s"points $playerOne - $playerTwo")
  }

    Given("""player one has {int} points""") { (points: Int) =>
    println(s"player one points $points")
  }

  Given("""player two has {int} points""") { (points: Int) =>
    println(s"player two points $points")
  }

  When("""the score is called out""") { () =>
    println("called out")
  }

  Then("""it is {string}""") { (score: String) =>
      println(s"score is $score")
  }
}
