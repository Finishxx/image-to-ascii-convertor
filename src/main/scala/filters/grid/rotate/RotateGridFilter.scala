package filters.grid.rotate

import filters.grid.GridAs2DSeqFilter

class RotateGridFilter[T](degrees: Int) extends GridAs2DSeqFilter[T] {

  private def rotate90(grid: Seq[Seq[T]]): Seq[Seq[T]] = grid.transpose

  private def rotateMinus90(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.transpose.map(_.reverse)

  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] =
    degrees % 360 match {
      case 0          => what
      case 180 | -180 => what.map(_.reverse).reverse
      case 90 | -270  => rotate90(what)
      case -90 | 270  => rotateMinus90(what)
      case _          => throw new IllegalArgumentException("Invalid rotation angle")
    }
}
