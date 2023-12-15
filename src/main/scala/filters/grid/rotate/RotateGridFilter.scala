package filters.grid.rotate

import filters.grid.GridAs2DSeqFilter

class RotateGridFilter(degrees: Int) extends GridAs2DSeqFilter {

  private def rotate90(grid: Seq[Seq[_]]): Seq[Seq[_]] = grid.transpose

  private def rotateMinus90(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.transpose.map(_.reverse)

  override def filter(what: Seq[Seq[_]]): Seq[Seq[_]] =
    degrees % 360 match {
      case 0          => what
      case 180 | -180 => what.map(_.reverse).reverse
      case 90 | -270  => rotate90(what)
      case -90 | 270  => rotateMinus90(what)
      case _          => throw new IllegalArgumentException("Invalid rotation angle")
    }
}
