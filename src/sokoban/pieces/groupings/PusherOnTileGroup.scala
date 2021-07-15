package sokoban.pieces.groupings

import sokoban.pieces.{Box, PlayerToken, Tile}

class PusherOnTileGroup(tile: Tile, pusher: PlayerToken)
  extends PieceGroup(tile, pusher, null) {

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxIn(box: Box): PieceGroup = {
    this//throw new IllegalStateException("Group with pusher can't accept box")
  }

  // STUB TO FAIL THE FIRST TEST
  override def moveBoxOut: (PieceGroup, Box) = (this,
    new Box("", sokoban.Position.STAY_PUT)) // {
//    throw new NullPointerException("Group with pusher doesn't have box to give")
//  }

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    this//throw new IllegalStateException("Group with pusher can't accept second pusher")
  }

  // STUB TO FAIL THE FIRST TEST
  override def movePlayerTokenOut: (PieceGroup, PlayerToken) =  (this,
    new PlayerToken(sokoban.Position.STAY_PUT)) // (
//    new TileGroup(this.pieceA.asInstanceOf[Tile]),
//    this.pieceB.asInstanceOf[PlayerToken]
//  )

}
