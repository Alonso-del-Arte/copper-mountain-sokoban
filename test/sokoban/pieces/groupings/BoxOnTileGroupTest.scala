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
    val incomingBox = new Box("Incoming Box",
      position.adjustBy(Position.MOVE_ONE_LEFT))
    fail("Finish writing test")
  }

  @Test def testMoveBoxOut(): Unit = {
    println("moveBoxOut")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    fail("Finish writing test")
  }

  @Test def testPlayerTokenIn(): Unit = {
    println("movePlayerTokenIn")
    val position = Position(Random.nextInt, Random.nextInt)
    val tile = new Tile(position)
    val box = new Box("Test Box", position)
    val tileAndBoxGroup = new BoxOnTileGroup(tile, box)
    val incomingPusher = new PlayerToken(position.adjustBy(Position.MOVE_ONE_LEFT))
    fail("Finish writing test")
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
