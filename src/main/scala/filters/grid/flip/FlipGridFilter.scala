package filters.grid.flip

import filters.grid.GridAs2DSeqFilter
import filters.grid.flip.Axis._

class FlipGridFilter(axis: Axis) extends GridAs2DSeqFilter {
  override def filter(what: Seq[Seq[_]]): Seq[Seq[_]] = axis match {
    case X => what.reverse
    case Y => what.map(_.reverse)
  }
}
