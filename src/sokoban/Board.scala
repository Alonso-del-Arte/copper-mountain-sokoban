package sokoban

import sokoban.pieces.Piece

class Board {
  private var hasBeenSetup: Boolean = false

  def setUp(pieces: List[Piece]): Unit = {
    this.hasBeenSetup = true
  }

  // STUB TO FAIL THE FIRST TEST
  def queryPosition(position: Position): List[Piece] = List()

}
