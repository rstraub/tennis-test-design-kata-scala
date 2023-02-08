package nl.codecraftr.scala.kata.tennis

import scala.Option.when

case class Deuce(game: Game) extends Score {
  override def describe: String = "deuce"

}

object Deuce extends Applicable[Deuce] {
  override def applies(game: Game): Option[Deuce] = {
    val applies = game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints == game.playerTwoPoints

    when(applies)(Deuce(game))
  }
}
