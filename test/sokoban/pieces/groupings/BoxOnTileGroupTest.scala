package sokoban.pieces.groupings

import sokoban.Position
import sokoban.pieces.{Box, PlayerToken, Tile}

import scala.util.Random
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class BoxOnTileGroupTest {

  @Test def testMoveBoxIn(): Unit = {
    println("moveBoxIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    val incomingBox = new Box("Unacceptable Incoming Box",
      position.adjustBy(Position.MOVE_ONE_LEFT))
    val exception = assertThrows(classOf[IllegalStateException], () => {
      val badGroup = tileAndBoxGroup.moveBoxIn(incomingBox)
      println("Should not have been able to create " + badGroup.toString)
    })
    val excMsg = exception.getMessage
    assert(excMsg != null, "Message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testMoveBoxOut(): Unit = {
    println("moveBoxOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    val tileGroup = new TileGroup(tile)
    val expected = (tileGroup, box)
    val actual = tileAndBoxGroup.moveBoxOut
    assertEquals(expected, actual)
  }

  @Test def testMovePlayerTokenIn(): Unit = {
    println("movePlayerTokenIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    val badPusher = new PlayerToken(position.adjustBy(Position.MOVE_ONE_LEFT))
    val throwable = assertThrows(classOf[IllegalStateException], () => {
      val badGroup = tileAndBoxGroup.movePlayerTokenIn(badPusher)
      println("Should not have been able to move " + badPusher.toString
        + " into " + tileAndBoxGroup.toString + " to create "
        + badGroup.toString)
    })
    val excMsg = throwable.getMessage
    assert(excMsg != null, "Message should not be null")
    println("\"" + excMsg + "\"")
  }

  @Test def testMovePlayerTokenOut(): Unit = {
    println("movePlayerTokenOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    fail("Finish writing test")
  }

}
