package nl.codecraftr.scala.kata.tennis

object Score {
  // TODO applies could return an Option[Score] and construct the object itself
  def toScore(playerOnePoints: Int, playerTwoPoints: Int): Score = {
    if (Winner.applies(playerOnePoints, playerTwoPoints))
      Winner(playerOnePoints, playerTwoPoints)
    else if (Deuce.applies(playerOnePoints, playerTwoPoints))
      Deuce(playerOnePoints, playerTwoPoints)
    else if (Advantage.applies(playerOnePoints, playerTwoPoints))
      Advantage(playerOnePoints, playerTwoPoints)
    else RunningScore(playerOnePoints, playerTwoPoints)
  }
}

trait Score {
  def describe: String
}
