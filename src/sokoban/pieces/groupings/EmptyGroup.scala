package sokoban.pieces.groupings

import sokoban.pieces.{Box, PlayerToken}

class EmptyGroup extends PieceGroup(null, null, null) {

  override def moveBoxIn(box: Box): PieceGroup = {
    throw new RuntimeException
//    throw new IllegalStateException("Group without tile can't accept box")
  }

  override def moveBoxOut: (PieceGroup, Box) = {
    throw new RuntimeException
//    throw new NullPointerException("Empty group doesn't have box to give")
  }

  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    throw new RuntimeException
//    throw new IllegalStateException("Group without tile can't accept pusher")
  }

  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = {
    throw new RuntimeException
//    throw new NullPointerException("Empty group doesn't have pusher to give")
  }

}
