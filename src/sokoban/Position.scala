package sokoban

object Position {

  val STAY_PUT = new Position(0, 0)
  val MOVE_ONE_UP = new Position(0, -1)
  val MOVE_ONE_LEFT = new Position(-1, 0)
  val MOVE_ONE_RIGHT = new Position(1, 0)
  val MOVE_ONE_DOWN = new Position(0, 1)

  def apply(x: Int, y: Int): Position = new Position(x, y)

}

class Position(val x: Int, val y: Int) {

  def adjustBy(adj: Position): Position =
    Position(this.x + adj.x, this.y + adj.y)

  def interveningPositions(to: Position): List[Position] =
    (this.x - to.x, this.y - to.y) match {
      case (0, 0) => List()
      case (_, 0) => val rows = if (this.x < to.x) (this.x + 1) until to.x
        else ((this.x - 1) until to.x) by -1
        rows.map(Position(_, this.y)).toList
      case (0, _) => val columns = if (this.y < to.y) (this.y + 1) until to.y
        else ((this.y - 1) until to.y) by -1
        columns.map(Position(this.x, _)).toList
      case _ => List()
  }

  override def toString: String = s"(${this.x.toString}, ${this.y.toString})"

  override def equals(obj: Any): Boolean = obj match {
    case obj: Position => (this.x == obj.x) && (this.y == obj.y)
    case _ => false
  }

  // STUB TO FAIL THE FIRST TEST
  override def hashCode(): Int = 0 // super.hashCode()

}
