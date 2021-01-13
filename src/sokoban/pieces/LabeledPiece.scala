package sokoban.pieces

import sokoban.Position

abstract class LabeledPiece(val label: String, initialPosition: Position,
                            movable: Boolean)
  extends Piece(initialPosition, movable) {

  override def toString: String = this.getClass.getSimpleName + " " + this.label

}
