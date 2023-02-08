package nl.codecraftr.scala.kata.tennis

object TennisGame {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    s"${toScore(playerOnePoints)}-${toScore(playerTwoPoints)}"
  }

  private def toScore(points: Int) =
      points match {
          case 0 => "love"
          case 1 => "fifteen"
          case 2 => "thirty"
          case 3 => "forty"
      }
}
