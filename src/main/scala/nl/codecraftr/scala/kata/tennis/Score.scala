package nl.codecraftr.scala.kata.tennis

object Score {
  // TODO applies could return an Option[Score] and construct the object itself
  def toScore(game: Game): Score = {
    if (Winner.applies(game)) Winner(game)
    else if (Deuce.applies(game)) Deuce(game)
    else if (Advantage.applies(game)) Advantage(game)
    else RunningScore(game)
  }
}

trait Score {
  def describe: String
}
