package nl.codecraftr.scala.kata.tennis

import scala.Option.when

private[tennis] case class Advantage(game: Game) extends Score {
  override def describe: String = s"advantage ${game.leadingPlayer}"
}

private[tennis] object Advantage extends GameState[Advantage] {
  override def appliesTo(game: Game): Option[Advantage] = {
    val applies =
      game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints != game.playerTwoPoints

    when(applies)(Advantage(game))
  }
}
