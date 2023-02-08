package nl.codecraftr.scala.kata.tennis

case class RunningScore(game: Game) extends Score {
  override def describe: String = {
    val playerOneScore = toScore(game.playerOnePoints)
    val playerTwoScore = toScore(game.playerTwoPoints)

    if (playerOneScore == playerTwoScore) s"$playerOneScore-all"
    else s"$playerOneScore-$playerTwoScore"
  }

  private def toScore(points: Int) =
    points match {
      case 0 => "love"
      case 1 => "fifteen"
      case 2 => "thirty"
      case 3 => "forty"
    }
}

case object RunningScore {
  def applies(game: Game): Boolean = {
    ???
  }
}
