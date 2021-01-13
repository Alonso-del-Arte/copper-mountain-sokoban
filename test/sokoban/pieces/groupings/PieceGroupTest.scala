package sokoban.pieces.groupings

import sokoban.Position
import sokoban.pieces.{Box, Brick, Goal, Piece, PlayerToken, Tile}

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PieceGroupTest {

  @Test def testSize(): Unit = {
    println("size")
    val position = Position(4, 7)
    val tile = new Tile(position)
    val goal = new Goal("Test box", position)
    val pusher = new PlayerToken(position)
    val emptyGroup = new PieceGroupImpl(null, null, null)
    val justTile = new PieceGroupImpl(tile, null, null)
    val tileAndGoal = new PieceGroupImpl(tile, goal, null)
    val tileGoalAndPusher = new PieceGroupImpl(tile, goal, pusher)
    assertEquals(0, emptyGroup.size)
    assertEquals(1, justTile.size)
    assertEquals(2, tileAndGoal.size)
    assertEquals(3, tileGoalAndPusher.size)
  }

  @Test def testConstructorRejectsBadNullAPlacement(): Unit = {
    val position = Position(1, 1)
    val tile = new Tile(position)
    val goal = new Goal("Test box", position)
    try {
      val badGroup = new PieceGroupImpl(null, tile, goal)
      val msg = "Should not have been able to create bad group " +
        badGroup.toString + " with null piece first"
      fail(msg)
    } catch {
      case npe: NullPointerException => val excMsg = npe.getMessage
        assert(excMsg != null, "Exception message should not be null")
        println("\"" + excMsg + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception to throw for bad null placement"
        fail(msg)
    }
  }

  @Test def testConstructorRejectsBadNullBPlacement(): Unit = {
    val position = Position(1, 2)
    val tile = new Tile(position)
    val box = new Box("Test box", position)
    try {
      val badGroup = new PieceGroupImpl(tile, null, box)
      val msg = "Should not have been able to create bad group " +
        badGroup.toString + " with null piece in the middle"
      fail(msg)
    } catch {
      case npe: NullPointerException => val excMsg = npe.getMessage
        assert(excMsg != null, "Exception message should not be null")
        println("\"" + excMsg + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception to throw for bad null placement"
        fail(msg)
    }
  }

  @Test def testConstructorRejectsBadNullACPlacement(): Unit = {
    val position = Position(2, 1)
    val brick = new Brick(position)
    try {
      val badGroup = new PieceGroupImpl(null, brick, null)
      val msg = "Should not have been able to create bad group " +
        badGroup.toString + " with non-null piece in the middle"
      fail(msg)
    } catch {
      case npe: NullPointerException => val excMsg = npe.getMessage
        assert(excMsg != null, "Exception message should not be null")
        println("\"" + excMsg + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception to throw for bad null placement"
        fail(msg)
    }
  }

  private class PieceGroupImpl(pieceA: Piece, pieceB: Piece, pieceC: Piece)
    extends PieceGroup(pieceA, pieceB, pieceC) {

    override def moveBoxIn(box: Box): PieceGroup = if (this.size == 3) {
      throw new IllegalStateException("No room for box")
    } else {
      new PieceGroupImpl(box, this.pieceA, this.pieceB)
    }

    override def moveBoxOut: (PieceGroup, Box) = this.pieceA match {
      case box: Box => (new PieceGroupImpl(this.pieceB, this.pieceA, null), box)
      case _ => throw new IllegalStateException("Box not at expected location")
    }

    override def movePlayerTokenIn(pusher: PlayerToken): PieceGroup = if (this.size == 3) {
      throw new IllegalStateException("No room for box")
    } else {
      new PieceGroupImpl(pusher, this.pieceA, this.pieceB)
    }

    override def movePlayerTokenOut: (PieceGroup, PlayerToken) = this.pieceA match {
      case pusher: PlayerToken =>
        (new PieceGroupImpl(this.pieceB, this.pieceA, null), pusher)
      case _ =>
        throw new IllegalStateException("Player token not at expected location")
    }

  }

}
