package sokoban

abstract class Piece(initialPosition: Position, val movable: Boolean) {
  private var currentPosition: Position = initialPosition

  // STUB TO FAIL THE FIRST TEST
  def getCurrentPosition: Position = Position.STAY_PUT

  // STUB TO FAIL THE FIRST TEST
  def move(direction: Position): Unit = {
    this.currentPosition = this.currentPosition.adjustTo(direction)
  }

}
