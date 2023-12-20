package filters.grid.scale

import filters.grid.Seq2DFilter

class ScaleSeq2DFilter[T](factor: Double) extends Seq2DFilter[T] {
  require(
    Seq(1, 4, 0.25).contains(factor),
    "Please use factors of 1, 4 or 0.25 only!")

  private def quadruple(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.flatMap(line => Seq.fill(2)(line.flatMap(Seq.fill(2)(_))))

  private def quarter(grid: Seq[Seq[T]]): Seq[Seq[T]] =
    grid.grouped(2).map(_.head).toSeq.map(_.grouped(2).map(_.head).toSeq)

  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = factor match {
    case 1    => what
    case 4    => quadruple(what)
    case 0.25 => quarter(what)
  }
}
