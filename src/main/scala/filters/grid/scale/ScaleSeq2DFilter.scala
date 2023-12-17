package filters.grid.scale

import filters.grid.Seq2DFilter

class ScaleSeq2DFilter[T](factor: Double) extends Seq2DFilter[T] {

  private def quadruple(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.map(_.flatMap(Seq.fill(4)(_)))

  private def quarter(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.map(_.grouped(4).map(_.head).toSeq)

  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = factor match {
    case 1    => what
    case 4    => quadruple(what)
    case 0.25 => quarter(what)
    case _    => throw new IllegalArgumentException("Invalid rotation angle")
  }
}
