package nl.codecraftr.scala.kata.tennis

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/** Each test case is an assignment. Find the flaw in the test case, describe
  * what it wrong with it in a comment and fix it.
  *
  * If you want extra learning, have a look at the {@WithClue} trait to add
  * better error messages. Another option is to look at ScalaChecks options to
  * generate test cases.
  */
class TennisSpec extends AnyFlatSpec with Matchers {
  // This test does not explain what it is doing
  "exercise example" should "be fixed" in {
    // Glorious fix
  }

  // TODO explain the flaw and improve the test
  "score" should "calculate a score" in {
    TennisGame.score(0, 0) shouldBe "love-all"
  }

  // TODO explain the flaw and improve the test
  it should "return love given 0 points" in {
    TennisGame.score(0, 1) shouldBe "love-fifteen"
    TennisGame.score(0, 2) shouldBe "love-thirty"
    TennisGame.score(0, 3) shouldBe "love-forty"
    TennisGame.score(1, 0) shouldBe "fifteen-love"
    TennisGame.score(2, 0) shouldBe "thirty-love"
    TennisGame.score(3, 0) shouldBe "forty-love"
  }

  private case class Score(var p1Points: Int, var p2Points: Int)
  private var score = Score(0, 0)

  // TODO explain the flaw and improve the test
  it should "return fifteen-all given 1 point for both players" in {
    score = Score(1, 1)
    TennisGame.score(score.p1Points, score.p2Points) shouldBe "fifteen-all"
  }

  // TODO explain the flaw and improve the test
  it should "return thirty-all given 2 point for both players" in {
    score = Score(2, 2)
    TennisGame.score(score.p1Points, score.p2Points) shouldBe "thirty-all"
  }

  // TODO explain the flaw and improve the test
  it should "return deuce given more than 3 points for both players" in {
    score.p1Points = 3
    score.p2Points = 3
    TennisGame.score(score.p1Points, score.p2Points) shouldBe "deuce"

    score.p1Points = 4
    score.p2Points = score.p1Points
    TennisGame.score(score.p1Points, score.p2Points) shouldBe "deuce"
  }

  // TODO explain the flaw and improve the test
  it should "return advantage p1 given more than 3 points for both players and a 1 point difference for p1" in {
    score.p1Points = score.p2Points + 1
    TennisGame.score(
      score.p1Points,
      score.p2Points
    ) shouldBe "advantage player one"
  }

  // TODO explain the flaw and improve the test
  it should "return advantage p2 given more than 3 points for both players and a 1 point difference for p2" in {
    (for (i <- 0 to 20) yield i)
      .filter(_ > 3)
      .foreach(p => {
        score.p1Points = 0
        TennisGame.score(
          p - 1,
          p
        ) shouldBe "advantage player two"
      })
  }

  // TODO explain the flaw and improve the test
  it should "return player x wins given 4 points for a player" in {
    assertScore(4, 0, true)
    assertScore(0, 4, false)
  }

  private def assertScore(p1: Int, p2: Int, p1Win: Boolean) = {
    val winner = if (p1Win) "one" else "two"
    TennisGame.score(
      p1,
      p2
    ) shouldBe s"player $winner wins"
  }

  // TODO explain the flaw and improve the test
  it should "return score given long game" in {
    var longGame = score.copy(p1Points = 10, p2Points = 9)
    assert(longGame.p1Points, longGame.p2Points, 0)

    longGame = score.copy(p1Points = 10, p2Points = 11)
    assert(longGame.p1Points, longGame.p2Points, 1)

    longGame = score.copy(p1Points = 14, p2Points = 12)
    assert(longGame.p1Points, longGame.p2Points, 2)

    longGame = score.copy(p1Points = 12, p2Points = 14)
    assert(longGame.p1Points, longGame.p2Points, 3)

    longGame = score.copy(p1Points = 14, p2Points = 14)
    assert(longGame.p1Points, longGame.p2Points, 999)

    def assert(p1: Int, p2: Int, assertion: Int) = {
      assertion match {
        case 0 => TennisGame.score(p1, p2) shouldBe "advantage player one"
        case 1 => TennisGame.score(p1, p2) shouldBe "advantage player two"
        case 2 => TennisGame.score(p1, p2) shouldBe "player one wins"
        case 3 => TennisGame.score(p1, p2) shouldBe "player two wins"
        case _ => TennisGame.score(p1, p2) shouldBe "deuce"
      }
    }
  }

  // Test impl, not behavior
}
