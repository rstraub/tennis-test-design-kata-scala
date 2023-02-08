package nl.codecraftr.scala.kata.tennis

case class Advantage(game: Game) extends Score {
  override def describe: String = s"advantage ${game.leadingPlayer}"
}

object Advantage extends Applicable[Advantage] {
  override def applies(game: Game): Option[Advantage] = {
    val applies =
      game.playerOnePoints >= 3 && game.playerTwoPoints >= 3 && game.playerOnePoints != game.playerTwoPoints

    if (applies) Some(Advantage(game))
    else None
  }
}
