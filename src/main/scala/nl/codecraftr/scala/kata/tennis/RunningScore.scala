package nl.codecraftr.scala.kata.tennis

private[tennis] case class RunningScore(game: Game) extends Score {
  private val LOVE = "love"
  private val FIFTEEN = "fifteen"
  private val THIRTY = "thirty"
  private val FORTY = "forty"

  override def describe: String = {
    val playerOneScore = toScore(game.playerOnePoints)
    val playerTwoScore = toScore(game.playerTwoPoints)

    if (playerOneScore == playerTwoScore) s"$playerOneScore-all"
    else s"$playerOneScore-$playerTwoScore"
  }

  private def toScore(points: Int) =
    points match {
      case 0 => LOVE
      case 1 => FIFTEEN
      case 2 => THIRTY
      case 3 => FORTY
    }
}

private[tennis] object RunningScore extends GameState[RunningScore] {
  override def appliesTo(game: Game): Option[RunningScore] = {
    Some(RunningScore(game))
  }
}
