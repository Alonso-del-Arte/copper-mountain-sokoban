package sokoban.pieces

import sokoban.Position

import scala.util.Random

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

object PieceTest {

  def choosePosition: Position = {
    val x = Random.nextInt(256) - 128
    val y = Random.nextInt(256) - 128
    Position(x, y)
  }

}

class PieceTest {

  @Test def testReferentialEquality(): Unit = {
    val position = PieceTest.choosePosition
    val piece = new PieceImpl(position, false)
    assertEquals(piece, piece)
  }

  @Test def testNotEqualsNull(): Unit = {
    val position = PieceTest.choosePosition
    val piece = new PieceImpl(position, true)
    assertNotEquals(piece, null)
  }

  @Test def testNotEqualsDifferentPosition(): Unit = {
    val positionA = PieceTest.choosePosition
    val positionB = positionA.adjustBy(Position.MOVE_ONE_RIGHT)
    val pieceA = new PieceImpl(positionA, true)
    val pieceB = new PieceImpl(positionB, true)
    assertNotEquals(pieceA, pieceB)
  }

  @Test def testEquals(): Unit = {
    println("equals")
    val position = PieceTest.choosePosition
    val somePiece = new PieceImpl(position, true)
    val samePiece = new PieceImpl(position, true)
    assertEquals(somePiece, samePiece)
  }

  @Test def testNotEqualsDifferentMobility(): Unit = {
    val position = PieceTest.choosePosition
    val movablePiece = new PieceImpl(position, true)
    val fixedPiece = new PieceImpl(position, false)
    assertNotEquals(movablePiece, fixedPiece)
  }

  @Test def testNotEqualsDifferentPieceType(): Unit = {
    val position = PieceTest.choosePosition
    val implPiece = new PieceImpl(position, true)
    val anonPiece = new Piece(position, true) {}
    assertNotEquals(implPiece, anonPiece)
  }

  private class PieceImpl(initialPosition: Position, movable: Boolean)
    extends Piece(initialPosition, movable) {

    override def toString: String =
      s"Piece originally at ${this.initialPosition}"

  }

}
