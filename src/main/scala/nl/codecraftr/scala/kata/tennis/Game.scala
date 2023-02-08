package nl.codecraftr.scala.kata.tennis

case class Game(playerOnePoints: Int, playerTwoPoints: Int) {
  def toScore: Score = {
    if (Winner.applies(this)) Winner(this)
    else if (Deuce.applies(this)) Deuce(this)
    else if (Advantage.applies(this)) Advantage(this)
    else RunningScore(this)
  }

  def leadingPlayer =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"
}
