package nl.codecraftr.scala.kata.tennis

case class Game(playerOnePoints: Int, playerTwoPoints: Int) {
  def toScore: Score = GameState.all
    .flatMap(_ appliesTo this)
    .head

  def leadingPlayer =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"
}
