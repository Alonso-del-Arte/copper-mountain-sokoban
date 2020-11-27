package sokoban

abstract class Piece(initialPosition: Position, val movable: Boolean) {
  private var currentPosition: Position = initialPosition

  // STUB TO FAIL THE FIRST TEST
  def getCurrentPosition: Position = Position.STAY_PUT

  // STUB TO FAIL THE FIRST TEST
  def canMoveTo(direction: Position): Boolean = false

  // STUB TO FAIL THE FIRST TEST
  def moveTo(direction: Position): Unit = {
    this.currentPosition = this.currentPosition.adjustBy(direction)
  }

}
