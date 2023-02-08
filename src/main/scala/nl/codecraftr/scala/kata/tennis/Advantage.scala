package nl.codecraftr.scala.kata.tennis

case class Advantage(game: Game) extends Score {
  override def describe: String = s"advantage ${game.leadingPlayer}"
}

object Advantage {
  def applies(game: Game): Boolean =
    game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints != game.playerTwoPoints
}
