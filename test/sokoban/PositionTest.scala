package sokoban

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PositionTest {

  @Test def testToString(): Unit = {
    println("toString")
    val position = Position(4, 7)
    val expected = "(4,7)"
    val actual = position.toString.replace(" ", "")
    assertEquals(expected, actual)
  }

  @Test def testReferentialEquality(): Unit = {
    val position = Position(4, 7)
    assertEquals(position, position)
  }

}
