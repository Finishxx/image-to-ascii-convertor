package asciiArtApp.model.grid

import helpers.TestWithSeq2D
import org.scalatest.FunSuite
import org.scalatest.Matchers.{convertToAnyShouldWrapper, equal}

class GridTest extends FunSuite with TestWithSeq2D {

  class Seq2D[T](val grid: Seq[Seq[T]]) extends Grid[T] {
    override def width: Int = grid.head.size

    override def height: Int = grid.size

    override def at(x: Int, y: Int): T = grid(x)(y)

    override def map[V](fun: T => V): Grid[V] =
      new Seq2D[V](grid.map(_.map(fun)))
  }

  test("toGrid works as expected") {
    new Seq2D(Seq()).toGrid should equal(Seq())
    new Seq2D(gridSeq1x1).toGrid should equal(gridSeq1x1)
    new Seq2D(gridSeq2x2).toGrid should equal(gridSeq2x2)
    new Seq2D(gridSeq3x3).toGrid should equal(gridSeq3x3)
  }
}
