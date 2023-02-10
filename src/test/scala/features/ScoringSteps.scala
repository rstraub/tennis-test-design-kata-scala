package features

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import nl.codecraftr.scala.kata.tennis.TennisGame
import org.scalatest.matchers.should.Matchers

class ScoringSteps extends ScalaDsl with EN with Matchers {
  private var actualScore = ""
  private var playerOnePoints = -1
  private var playerTwoPoints = -1

  Given("""the points scored are""") { (points: DataTable) =>
    playerOnePoints = points.cell(1, 0).toInt
    playerTwoPoints = points.cell(1, 1).toInt
  }

  When("""the score is called out""") { () =>
    actualScore = TennisGame.score(playerOnePoints, playerTwoPoints)
  }

  Then("""the score should be {string}""") { (expectedScore: String) =>
    actualScore shouldBe expectedScore
  }

  Then("""the advantage is for {string}""") { (leader: String) =>
    actualScore shouldBe s"advantage $leader"
  }

  Then("""the winner is {string}""") { (winner: String) =>
    actualScore shouldBe s"$winner wins"
  }
}
