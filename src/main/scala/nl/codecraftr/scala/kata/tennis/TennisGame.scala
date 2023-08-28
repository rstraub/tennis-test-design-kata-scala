package nl.codecraftr.scala.kata.tennis

object TennisGame extends App {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    Game(playerOnePoints, playerTwoPoints).toScore.describe
  }
}
