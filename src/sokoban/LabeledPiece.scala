package sokoban

abstract class LabeledPiece(val label: String, initialPosition: Position, movable: Boolean)
  extends Piece(initialPosition, movable) {

}
