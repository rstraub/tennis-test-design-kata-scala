package nl.codecraftr.scala.kata.tennis

trait Applicable[+T <: Score] {
  def appliesTo(game: Game): Option[T]
}

object Applicable {
  def all: Seq[Applicable[Score]] = Seq(
    Winner,
    Advantage,
    Deuce,
    RunningScore
  )
}
