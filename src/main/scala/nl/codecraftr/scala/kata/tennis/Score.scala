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

sealed trait Score {
  def describe: String
}

trait PlayerLeading {
  def leadingPlayer(playerOnePoints: Int, playerTwoPoints: Int) =
    if (playerOnePoints > playerTwoPoints) "player one"
    else "player two"
}

case class Deuce(playerOnePoints: Int, playerTwoPoints: Int) extends Score {
  override def describe: String = "deuce"

}

object Deuce {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints == playerTwoPoints
}

case class Winner(playerOnePoints: Int, playerTwoPoints: Int) extends Score with PlayerLeading {
  override def describe: String =
    s"${leadingPlayer(playerOnePoints, playerTwoPoints)} wins"
}

object Winner {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean = {
    val diff = playerOnePoints - playerTwoPoints
    (playerOnePoints >= 4 || playerTwoPoints >= 4) && diff.abs >= 2
  }
}

case class Advantage(playerOnePoints: Int, playerTwoPoints: Int) extends Score with PlayerLeading {
  override def describe: String =
    s"advantage ${leadingPlayer(playerOnePoints, playerTwoPoints)}"
}

object Advantage {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean =
    playerOnePoints >= 3 && playerTwoPoints >= 3 && playerOnePoints != playerTwoPoints
}

case class RunningScore(playerOnePoints: Int, playerTwoPoints: Int)
    extends Score {
  override def describe: String = {
    def toScore(points: Int) =
      points match {
        case 0 => "love"
        case 1 => "fifteen"
        case 2 => "thirty"
        case 3 => "forty"
      }

    val playerOneScore = toScore(playerOnePoints)

    val playerTwoScore = toScore(playerTwoPoints)
    if (playerOneScore == playerTwoScore) s"$playerOneScore-all"
    else s"$playerOneScore-$playerTwoScore"
  }
}

case object RunningScore {
  def applies(playerOnePoints: Int, playerTwoPoints: Int): Boolean = {
    ???
  }
}
