package nl.codecraftr.scala.kata.tennis

case class Winner(playerOnePoints: Int, playerTwoPoints: Int)
    extends Score
    with PlayerLeading {
  override def describe: String =
    s"${leadingPlayer(playerOnePoints, playerTwoPoints)} wins"
}

object Winner {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean = {
    val diff = playerOnePoints - playerTwoPoints
    (playerOnePoints >= 4 || playerTwoPoints >= 4) && diff.abs >= 2
  }
}
