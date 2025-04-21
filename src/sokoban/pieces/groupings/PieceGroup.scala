package sokoban.pieces.groupings

import sokoban.pieces.{Box, Piece, PlayerToken}

abstract class PieceGroup(val pieceA: Piece,
                          val pieceB: Piece,
                          val pieceC: Piece = null) {

  val size: Int = (this.pieceA, this.pieceB, this.pieceC) match {
    case (null, null, null) => 0
    case (null, _, null) =>
      val excMsg = "Non-null piece should be first, not in the middle"
      throw new NullPointerException(excMsg)
    case (_, null, null) => 1
    case (_, _, null) => 2
    case (null, null, _) => val excMsg = "Non-null piece should be first, not last"
      throw new NullPointerException(excMsg)
    case (null, _, _) => val excMsg = "Null piece should be last, not first"
      throw new NullPointerException(excMsg)
    case (_, null, _) => val excMsg = "Null piece should be last, not in the middle"
      throw new NullPointerException(excMsg)
    case _ => 3
  }

  def moveBoxIn(box: Box): PieceGroup

  def moveBoxOut: (PieceGroup, Box)

  def movePlayerTokenIn(pusher: PlayerToken): PieceGroup

  def movePlayerTokenOut: (PieceGroup, PlayerToken)

  // TODO: Write tests for this
  override def equals(obj: Any): Boolean = false

  // TODO: Write tests for this
  override def hashCode(): Int = 0

}
