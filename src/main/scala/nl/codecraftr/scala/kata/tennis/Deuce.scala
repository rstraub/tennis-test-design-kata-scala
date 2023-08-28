package nl.codecraftr.scala.kata.tennis

import scala.Option.when

private[tennis] case class Deuce(game: Game) extends Score {
  override def describe: String = "deuce"

}

private[tennis] object Deuce extends GameState[Deuce] {
  override def appliesTo(game: Game): Option[Deuce] = {
    val applies =
      game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints == game.playerTwoPoints

    when(applies)(Deuce(game))
  }
}
