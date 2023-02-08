package nl.codecraftr.scala.kata.tennis

object TennisGame {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    val playerOneScore = toScore(playerOnePoints)
    val playerTwoScore = toScore(playerTwoPoints)

    if (playerOneScore == playerTwoScore) {
      if (playerOnePoints < 3) s"$playerOneScore-all"
      else "deuce"
    } else s"$playerOneScore-$playerTwoScore"
  }

  private def toScore(points: Int) =
    points match {
      case 0 => "love"
      case 1 => "fifteen"
      case 2 => "thirty"
      case 3 => "forty"
      case _ => "advantage"
    }
}
