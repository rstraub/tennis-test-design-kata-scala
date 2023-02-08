package nl.codecraftr.scala.kata.tennis

case class Deuce(game: Game) extends Score {
  override def describe: String = "deuce"

}

object Deuce {
  def applies(game: Game): Boolean =
    game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints == game.playerTwoPoints
}
