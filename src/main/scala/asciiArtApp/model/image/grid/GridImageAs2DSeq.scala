package asciiArtApp.model.image.grid

import scala.collection.mutable

class GridImageAs2DSeq[T](grid: Seq[Seq[T]]) extends GridImage[T] {
  require(
    grid.forall(_.size == grid.head.size),
    "Malformed grid! Please provide grid with equally sized rows.")

  override def width: Int = grid.size

  override def height: Int = grid.head.size

  override def at(x: Int, y: Int): T = grid(x - 1)(y - 1)

  override def map[V](fun: T => V): GridImage[V] =
    new GridImageAs2DSeq(grid.map(_.map(fun)))

  override def mapWithIndex[V](fun: (T, (Int, Int)) => V): GridImage[V] =
    new GridImageAs2DSeq(grid.zipWithIndex.map {
      case (row, rowIndex) =>
        row.zipWithIndex.map {
          case (element, columnIndex) =>
            fun(element, (rowIndex, columnIndex))
        }
    })

  override def toGrid: Seq[Seq[T]] = grid
}
