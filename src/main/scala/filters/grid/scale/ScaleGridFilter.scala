package filters.grid.scale

import filters.grid.GridAs2DSeqFilter

class ScaleGridFilter(factor: Double) extends GridAs2DSeqFilter {

  private def quadruple(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.map(_.flatMap(Seq.fill(4)(_)))

  private def quarter(grid: Seq[Seq[_]]): Seq[Seq[_]] =
    grid.map(_.grouped(4).map(_.head).toSeq)

  override def filter(what: Seq[Seq[_]]): Seq[Seq[_]] = factor match {
    case 1    => what
    case 4    => quadruple(what)
    case 0.25 => quarter(what)
    case _    => throw new IllegalArgumentException("Invalid rotation angle")
  }
}
