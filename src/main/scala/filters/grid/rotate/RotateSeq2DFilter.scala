package filters.grid.rotate

import filters.grid.Seq2DFilter

class RotateSeq2DFilter[T](degrees: Int) extends Seq2DFilter[T] {
  require(degrees % 90 == 0, "Please input degrees as multiples of 90!")

  private def rotate90(grid: Seq[Seq[T]]): Seq[Seq[T]] = grid.transpose.reverse

  private def rotateMinus90(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.transpose.map(_.reverse)

  private def rotate180(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.map(_.reverse).reverse

  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] =
    degrees % 360 match {
      case 0          => what
      case 180 | -180 => rotate180(what)
      case 90 | -270  => rotate90(what)
      case -90 | 270  => rotateMinus90(what)
      case _          => throw new IllegalArgumentException("Invalid rotation angle")
    }
}
