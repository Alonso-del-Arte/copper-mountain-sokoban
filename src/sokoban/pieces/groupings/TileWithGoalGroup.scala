package sokoban.pieces.groupings

import sokoban.pieces.{Box, Goal, PlayerToken, Tile}

class TileWithGoalGroup(tile: Tile, goal: Goal)
  extends PieceGroup(tile, goal, null)  {

  override def moveBoxIn(box: Box): PieceGroup = {
    new TileGoalBoxGroup(this.pieceA.asInstanceOf[Tile],
      this.pieceB.asInstanceOf[Goal], box)
  }

  override def moveBoxOut: (PieceGroup, Box) = {
    throw new NullPointerException("Group doesn't have box to give")
  }

  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    new TileGoalPusherGroup(this.pieceA.asInstanceOf[Tile],
      this.pieceB.asInstanceOf[Goal], pusher)
  }

  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = {
    throw new NullPointerException("Group doesn't have pusher to give")
  }

}
