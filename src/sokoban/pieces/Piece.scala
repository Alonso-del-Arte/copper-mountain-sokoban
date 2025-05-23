package sokoban.pieces

import sokoban.Position

/**
 * Represents a piece in a Sokoban board.
 * @param initialPosition The piece's initial position.
 * @param movable Whether the piece is movable or not in general (a movable
 *                piece may become immovable if pushed into a position from
 *                where it can't be moved back).
 */
abstract class Piece(val initialPosition: Position, val movable: Boolean) {
  private var currentPosition: Position = initialPosition

  override def equals(obj: Any): Boolean = obj match {
    case other: Piece => this.initialPosition == other.initialPosition &&
      this.movable == other.movable && this.getClass == other.getClass
    case _ => false
  }

  // STUB TO FAIL THE FIRST TEST
  def getCurrentPosition: Position = Position.STAY_PUT

  // STUB TO FAIL THE FIRST TEST
  def canMoveTo(direction: Position): Boolean = false

  // STUB TO FAIL THE FIRST TEST
  def moveTo(direction: Position): Unit = {
    this.currentPosition = this.currentPosition.adjustBy(direction)
  }

}
