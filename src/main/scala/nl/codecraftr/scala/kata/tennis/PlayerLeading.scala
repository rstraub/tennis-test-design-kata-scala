package nl.codecraftr.scala.kata.tennis

trait PlayerLeading {
  def leadingPlayer(playerOnePoints: Int, playerTwoPoints: Int) =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"
}
