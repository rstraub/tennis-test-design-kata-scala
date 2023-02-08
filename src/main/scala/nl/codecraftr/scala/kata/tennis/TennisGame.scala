package nl.codecraftr.scala.kata.tennis

import nl.codecraftr.scala.kata.tennis.Score.toScore

object TennisGame {
  def score(playerOnePoints: Int, playerTwoPoints: Int): String = {
    toScore(Game(playerOnePoints, playerTwoPoints)).describe
  }
}
