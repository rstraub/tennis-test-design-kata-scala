package nl.codecraftr.scala.kata.tennis

case class Game(playerOnePoints: Int, playerTwoPoints: Int) {
  def toScore: Score = {
    this match {
      case game if Winner.applies(game).isDefined    => Winner(game)
      case game if Deuce.applies(game).isDefined     => Deuce(game)
      case game if Advantage.applies(game).isDefined => Advantage(game)
      case game                                      => RunningScore(game)
    }
  }

  def leadingPlayer =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"
}
