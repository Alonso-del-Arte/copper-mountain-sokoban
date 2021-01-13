package sokoban.pieces.groupings

import sokoban.pieces.{Box, PlayerToken, Tile}

class TileGroup(tile: Tile) extends PieceGroup(tile, null, null) {

  override def moveBoxIn(box: Box): PieceGroup = {
    new BoxOnTileGroup(this.pieceA.asInstanceOf[Tile], box)
  }

  override def moveBoxOut: (PieceGroup, Box) = {
    throw new NullPointerException("Group with just tile doesn't have box to give")
  }

  override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = {
    new PusherOnTileGroup(this.pieceA.asInstanceOf[Tile], pusher)
  }

  override def movePlayerTokenOut: (PieceGroup, PlayerToken) = {
    throw new NullPointerException("Empty group doesn't have pusher to give")
  }

}
