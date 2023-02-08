package nl.codecraftr.scala.kata.tennis

case class RunningScore(game: Game)
    extends Score {
  override def describe: String = {
    def toScore(points: Int) =
      points match {
        case 0 => "love"
        case 1 => "fifteen"
        case 2 => "thirty"
        case 3 => "forty"
      }

    val playerOneScore = toScore(game.playerOnePoints)

    val playerTwoScore = toScore(game.playerTwoPoints)
    if (playerOneScore == playerTwoScore) s"$playerOneScore-all"
    else s"$playerOneScore-$playerTwoScore"
  }
}

case object RunningScore {
  def applies(game: Game): Boolean = {
    ???
  }
}
