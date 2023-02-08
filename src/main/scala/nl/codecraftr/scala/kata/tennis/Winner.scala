package nl.codecraftr.scala.kata.tennis

case class Winner(game: Game)
    extends Score
    with PlayerLeading {
  override def describe: String =
    s"${leadingPlayer(game.playerOnePoints, game.playerTwoPoints)} wins"
}

object Winner {
  def applies(game: Game): Boolean = {
    val diff = game.playerOnePoints - game.playerTwoPoints
    (game.playerOnePoints >= 4 || game.playerTwoPoints >= 4) && diff.abs >= 2
  }
}
