package nl.codecraftr.scala.kata.tennis

import nl.codecraftr.scala.kata.tennis.Score.toScore

object TennisGame {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    toScore(playerOnePoints, playerTwoPoints) match {
      case Winner => s"${leadingPlayer(playerOnePoints, playerTwoPoints)} wins"
      case Advantage =>
        s"advantage ${leadingPlayer(playerOnePoints, playerTwoPoints)}"
      case Deuce        => Deuce.describe
      case RunningScore => getRunningScore(playerOnePoints, playerTwoPoints)
    }
  }

  private def leadingPlayer(playerOnePoints: Int, playerTwoPoints: Int) =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"

  private def getRunningScore(playerOnePoints: Int, playerTwoPoints: Int) = {
    def toScore(points: Int) =
      points match {
        case 0 => "love"
        case 1 => "fifteen"
        case 2 => "thirty"
        case 3 => "forty"
      }

    val playerOneScore = toScore(playerOnePoints)

    val playerTwoScore = toScore(playerTwoPoints)
    if (playerOneScore == playerTwoScore) s"$playerOneScore-all"
    else s"$playerOneScore-$playerTwoScore"
  }
}

sealed trait Score {
  def describe: String
}

case object Deuce extends Score {
  override def describe: String = "deuce"
}

case object Winner extends Score {
  override def describe: String = "wins"
}

case object Advantage extends Score {
  override def describe: String = "advantage"
}

case object RunningScore extends Score {
  override def describe: String = ""
}

object Score {
  def toScore(playerOnePoints: Int, playerTwoPoints: Int): Score = {
    if (hasWinner(playerOnePoints, playerTwoPoints)) Winner
    else if (isDeuce(playerOnePoints, playerTwoPoints)) Deuce
    else if (isAdvantage(playerOnePoints, playerTwoPoints)) Advantage
    else RunningScore
  }

  private def hasWinner(playerOnePoints: Int, playerTwoPoints: Int) = {
    val diff = playerOnePoints - playerTwoPoints
    (playerOnePoints >= 4 || playerTwoPoints >= 4) && diff.abs >= 2
  }

  private def isDeuce(playerOnePoints: Int, playerTwoPoints: Int) =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints == playerTwoPoints

  private def isAdvantage(playerOnePoints: Int, playerTwoPoints: Int) =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints != playerTwoPoints
}
