package nl.codecraftr.scala.kata.tennis

case class Winner(game: Game) extends Score {
  override def describe: String = s"${game.leadingPlayer} wins"
}

object Winner extends Applicable[Winner] {
  def applies(game: Game): Option[Winner ] = {
    val diff = game.playerOnePoints - game.playerTwoPoints
    val applies = (game.playerOnePoints >= 4 || game.playerTwoPoints >= 4) && diff.abs >= 2

    if (applies) Some(Winner(game))
    else None
  }
}
