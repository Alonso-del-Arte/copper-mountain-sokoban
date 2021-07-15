package sokoban.pieces.groupings

import sokoban.pieces.{Box, Goal, PlayerToken, Tile}

class TileGoalPusherGroup(tile: Tile, goal: Goal, pusher: PlayerToken)
  extends PieceGroup(tile, goal, pusher) {

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxIn(box: Box): PieceGroup = {
    this//throw new IllegalStateException("Group without tile can't accept box")
  }

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxOut: (PieceGroup, Box) = (this,
    new Box("", sokoban.Position.STAY_PUT)) // {
  //    throw new NullPointerException("Empty group doesn't have box to give")
  //  }

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    this//throw new IllegalStateException("Group without tile can't accept pusher")
  }

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = (this,
    new PlayerToken(sokoban.Position.STAY_PUT)) // {
  //    throw new NullPointerException("Empty group doesn't have pusher to give")
  //  }

}
