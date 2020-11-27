package sokoban

import javax.naming.ldap.Rdn

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PositionTest {

  @Test def testApply(): Unit = {
    val x = 448
    val y = 605
    val position = Position.apply(x, y)
    assertEquals(x, position.x)
    assertEquals(y, position.y)
  }

  @Test def testAdjustBy(): Unit = {
    println("adjustBy")
    val startingPosition = Position(5, 3)
    val adjustment = Position(-3, 5)
    val expected = Position(2, 8)
    val actual = startingPosition.adjustBy(adjustment)
    assertEquals(expected, actual)
  }

  @Test def testNoInterveningPositions(): Unit = {
    val position = Position(25, 28)
    val expected = List()
    val actual = position.interveningPositions(position)
    assertEquals(expected, actual)
  }

  @Test def testInterveningPositions(): Unit = {
    println("interveningPositions")
    val start = Position(2, 5)
    val end = Position(5, 4)
    val expected = List(Position(3, 5), Position(4, 5), Position(5, 5),
      Position(2, 4), Position(3, 4), Position(4, 4))
    val actual = start.interveningPositions(end)
    for (pos <- expected) {
      val msg =
        s"List of intervening positions from ${start.toString} to ${end.toString} should contain ${pos.toString}"
      assert(actual.contains(pos), msg)
    }
    val msg = "Extraneous intervening positions should not be listed"
    assertEquals(expected.size, actual.size, msg)
  }

  @Test def testInterveningPositionsHorizontal(): Unit = {
    val start = Position(25, 28)
    val end = Position(30, 28)
    val expected = List(Position(26, 28), Position(27, 28), Position(28, 28), Position(29, 28))
    val actual = start.interveningPositions(end)
    assertEquals(expected, actual)
  }

  @Test def testInterveningPositionsVertical(): Unit = {
    val start = Position(-3, -3)
    val end = Position(-3, 2)
    val expected = List(Position(-3, -2), Position(-3, -1), Position(-3, 0), Position(-3, 1))
    val actual = start.interveningPositions(end)
    assertEquals(expected, actual)
  }

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

  @Test def testNotEqualsNull(): Unit = {
    val position = Position(3, 8)
    assertNotEquals(position, null)
  }

  @Test def testEquals(): Unit = {
    println("equals")
    val somePosition = Position(-3, 10)
    val samePosition = Position(-3, 10)
    assertEquals(somePosition, samePosition)
  }

  @Test def testNotEqualsObjectOtherClass(): Unit = {
    val position = Position(5, 3)
    val rdn = new Rdn("OU=Sales+CN=J.Smith")
    assertNotEquals(position, rdn)
  }

  @Test def testNotEqualsDiffXSameY(): Unit = {
    val positionA = Position(82, 73)
    val positionB = Position(55, 73)
    assertNotEquals(positionA, positionB)
  }

  @Test def testNotEqualsSameXDiffY(): Unit = {
    val positionA = Position(-2, 64)
    val positionB = Position(-2, -83)
    assertNotEquals(positionA, positionB)
  }

}
