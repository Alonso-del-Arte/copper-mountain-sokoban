package sokoban.pieces.groupings

import sokoban.Position
import sokoban.pieces.{Box, PlayerToken, Tile}

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TileGroupTest {

  @Test def testMoveBoxIn(): Unit = {
    println("moveBoxIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val tileGroup = new TileGroup(tile)
    val incomingBox = new Box("Incoming Box",
      position.adjustBy(Position.MOVE_ONE_LEFT))
    val boxMovedInGroup = tileGroup.moveBoxIn(incomingBox)
    val msg = "Group with box moved in should be of type BoxOnTileGroup"
    assert(boxMovedInGroup.isInstanceOf[BoxOnTileGroup], msg)
    assertEquals(incomingBox, boxMovedInGroup.pieceB)
  }

  @Test def testMoveBoxOut(): Unit = {
    println("moveBoxOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val tileGroup = new TileGroup(tile)
    try {
      val badBox = tileGroup.moveBoxOut._2
      val msg =
        "Trying to get box out of group with no box should not have given " +
          badBox.toString
      fail(msg)
    } catch {
      case npe: NullPointerException => val excMsg = npe.getMessage
        val msg = "Exception message should not be null"
        assert(excMsg != null, msg)
        println("Trying to get box from boxless group correctly caused NullPointerException")
        println("\"" + excMsg + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception for trying to get box from group with no box"
        fail(msg)
    }
  }

  @Test def testPlayerTokenIn(): Unit = {
    println("movePlayerTokenIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val tileGroup = new TileGroup(tile)
    val incomingPusher = new PlayerToken(position.adjustBy(Position.MOVE_ONE_LEFT))
    val pusherMovedInGroup = tileGroup.movePlayerTokenIn(incomingPusher)
    val msg = "Group with pusher moved in should be of type PusherOnTileGroup"
    assert(pusherMovedInGroup.isInstanceOf[PusherOnTileGroup], msg)
    assertEquals(incomingPusher, pusherMovedInGroup.pieceB)
  }

  @Test def testMovePlayerTokenOut(): Unit = {
    println("movePlayerTokenOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val tileGroup = new TileGroup(tile)
    try {
      val badPusher = tileGroup.movePlayerTokenOut._2
      val msg =
        "Trying to get pusher out of group with no pusher should not have given " +
          badPusher.toString
      fail(msg)
    } catch {
      case npe: NullPointerException => val excMsg = npe.getMessage
        val msg = "Exception message should not be null"
        assert(excMsg != null, msg)
        println("Trying to get pusher from tile group correctly caused NullPointerException")
        println("\"" + excMsg + "\"")
      case re: RuntimeException => val msg = re.getClass.getName +
        " is the wrong exception for trying to pusher from group with no pusher"
        fail(msg)
    }
  }

}
