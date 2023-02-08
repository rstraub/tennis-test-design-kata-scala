package nl.codecraftr.scala.kata.tennis

trait GameState[+T <: Score] {
  def appliesTo(game: Game): Option[T]
}

object GameState {
  def all: Seq[GameState[Score]] = Seq(
    Winner,
    Advantage,
    Deuce,
    RunningScore
  )
}
