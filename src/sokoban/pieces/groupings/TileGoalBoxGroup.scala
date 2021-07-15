package sokoban.pieces.groupings

import sokoban.pieces.{Box, Goal, PlayerToken, Tile}

class TileGoalBoxGroup(tile: Tile, goal: Goal, box: Box)
  extends PieceGroup(tile, goal, box) {

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxIn(box: Box): PieceGroup = {
    this//throw new IllegalStateException("Group with box can't accept second box")
  }

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxOut: (PieceGroup, Box) = (this,
    new Box("", sokoban.Position.STAY_PUT)) // (
//    new TileGroup(this.pieceA.asInstanceOf[Tile]),
//    this.pieceB.asInstanceOf[Box]
//  )

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    this//throw new IllegalStateException("Group with box can't accept pusher")
  }

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = (this,
    new PlayerToken(sokoban.Position.STAY_PUT)) // {
//    throw new NullPointerException("Group with box doesn't have pusher to give")
//  }

}
