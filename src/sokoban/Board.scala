package sokoban

import sokoban.pieces.Piece

class Board(val initialState: BoardState) {
  private var states: List[BoardState] = List(initialState)
  private var moveCounter = 0
  private var pushCounter = 0

  // STUB TO FAIL THE FIRST TEST
  def queryPosition(position: Position): List[Piece] = List()

}
