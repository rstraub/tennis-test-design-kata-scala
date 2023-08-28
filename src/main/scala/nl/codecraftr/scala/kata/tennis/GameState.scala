package nl.codecraftr.scala.kata.tennis

private[tennis] trait GameState[+T <: Score] {
  def appliesTo(game: Game): Option[T]
}

private[tennis] object GameState {
  def all: Seq[GameState[Score]] = Seq(
    Winner,
    Advantage,
    Deuce,
    RunningScore
  )
}
