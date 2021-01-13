package sokoban.pieces.groupings

import sokoban.pieces.{Box, Brick, PlayerToken}

class BrickGroup(brick: Brick) extends PieceGroup(brick, null, null) {

  override def moveBoxIn(box: Box): PieceGroup = {
    throw new IllegalStateException("Group with wall brick can't accept box")
  }

  override def moveBoxOut: (PieceGroup, Box) = {
    throw new NullPointerException("Group with wall brick doesn't have box to give")
  }

  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    throw new IllegalStateException("Group with wall brick can't accept pusher")
  }

  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = {
    throw new NullPointerException("Group with wall brick doesn't have pusher to give")
  }

}
