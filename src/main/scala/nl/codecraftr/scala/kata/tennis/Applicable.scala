package nl.codecraftr.scala.kata.tennis

trait Applicable[T] {
    def applies(game: Game): Option[T]
}
