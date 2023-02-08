package nl.codecraftr.scala.kata.tennis

case class Deuce(playerOnePoints: Int, playerTwoPoints: Int) extends Score {
  override def describe: String = "deuce"

}

object Deuce {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints == playerTwoPoints
}
