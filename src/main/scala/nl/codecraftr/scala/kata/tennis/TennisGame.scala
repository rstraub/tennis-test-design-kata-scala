package nl.codecraftr.scala.kata.tennis

object TennisGame {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    if (isDeuce(playerOnePoints, playerTwoPoints)) "deuce"
    else if (isAdvantage(playerOnePoints, playerTwoPoints))
      s"advantage ${leadingPlayer(playerOnePoints, playerTwoPoints)}"
    else getRunningScore(playerOnePoints, playerTwoPoints)
  }

  private def isDeuce(playerOnePoints: Int, playerTwoPoints: Int) =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints == playerTwoPoints

  private def isAdvantage(playerOnePoints: Int, playerTwoPoints: Int) =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints != playerTwoPoints

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
