package sokoban

object Position {

  val STAY_PUT = new Position(0, 0)
  val MOVE_ONE_UP = new Position(0, -1)
  val MOVE_ONE_LEFT = new Position(-1, 0)
  val MOVE_ONE_RIGHT = new Position(1, 0)
  val MOVE_ONE_DOWN = new Position(0, 1)

}

class Position(val x: Int, val y: Int) {

  // STUB TO FAIL THE FIRST TEST
  def adjustTo(adjustment: Position): Position = Position.STAY_PUT

  // STUB TO FAIL THE FIRST TEST
  def interveningPositions(to: Position): List[Position] = List(Position.STAY_PUT)

}
