package nl.codecraftr.scala.kata.tennis

import scala.Option.when

private[tennis] case class Winner(game: Game) extends Score {
  override def describe: String = s"${game.leadingPlayer} wins"
}

private[tennis] object Winner extends GameState[Winner] {
  def appliesTo(game: Game): Option[Winner] = {
    val diff = game.playerOnePoints - game.playerTwoPoints
    val applies =
      (game.playerOnePoints >= 4 || game.playerTwoPoints >= 4) && diff.abs >= 2

    when(applies)(Winner(game))
  }
}
