package sokoban.pieces.groupings

import sokoban.Position
import sokoban.pieces.{Box, Goal, PlayerToken, Tile}

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class TileWithGoalGroupTest {

  @Test def testMoveBoxIn(): Unit = {
    println("moveBoxIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val goal = new Goal("Test Goal", position)
    val tileWithGoalGroup = new TileWithGoalGroup(tile, goal)
    val incomingBox = new Box("Incoming Box",
      position.adjustBy(Position.MOVE_ONE_RIGHT))
    val boxMovedInGroup = tileWithGoalGroup.moveBoxIn(incomingBox)
    val msg = "Group with box moved in should be of type TileGoalBoxGroup"
    assert(boxMovedInGroup.isInstanceOf[TileGoalBoxGroup], msg)
    assertEquals(incomingBox, boxMovedInGroup.pieceC)
  }

  @Test def testMoveBoxOut(): Unit = {
    println("moveBoxOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val goal = new Goal("Test Goal", position)
    val tileWithGoalGroup = new TileWithGoalGroup(tile, goal)
    try {
      val badBox = tileWithGoalGroup.moveBoxOut._2
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
    val goal = new Goal("Test Goal", position)
    val tileWithGoalGroup = new TileWithGoalGroup(tile, goal)
    val incomingPusher = new PlayerToken(position.adjustBy(Position.MOVE_ONE_RIGHT))
    val pusherMovedInGroup = tileWithGoalGroup.movePlayerTokenIn(incomingPusher)
    val msg = "Group with pusher moved in should be of type TileGoalPusherGroup"
    assert(pusherMovedInGroup.isInstanceOf[TileGoalPusherGroup], msg)
    assertEquals(incomingPusher, pusherMovedInGroup.pieceC)
  }

  @Test def testMovePlayerTokenOut(): Unit = {
    println("movePlayerTokenOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val goal = new Goal("Test Goal", position)
    val tileWithGoalGroup = new TileWithGoalGroup(tile, goal)
    try {
      val badPusher = tileWithGoalGroup.movePlayerTokenOut._2
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
