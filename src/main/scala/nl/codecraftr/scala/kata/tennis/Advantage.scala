package nl.codecraftr.scala.kata.tennis

case class Advantage(playerOnePoints: Int, playerTwoPoints: Int)
    extends Score
    with PlayerLeading {
  override def describe: String =
    s"advantage ${leadingPlayer(playerOnePoints, playerTwoPoints)}"
}

object Advantage {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints != playerTwoPoints
}
