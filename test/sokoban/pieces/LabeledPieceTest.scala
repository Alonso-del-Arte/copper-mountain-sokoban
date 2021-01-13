package sokoban.pieces

import sokoban.Position

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class LabeledPieceTest {

  @Test def testToString(): Unit = {
    println("toString")
    val expected = "LabeledPieceImpl$ Test Piece"
    val actual = LabeledPieceImpl.toString
    assertEquals(expected, actual)
  }

  private object LabeledPieceImpl extends LabeledPiece("Test Piece",
    Position.STAY_PUT, false)

}
