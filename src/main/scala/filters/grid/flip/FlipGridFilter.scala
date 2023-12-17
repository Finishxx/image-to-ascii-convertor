package filters.grid.flip

import filters.grid.GridAs2DSeqFilter
import filters.grid.flip.Axis._

class FlipGridFilter[T](axis: Axis) extends GridAs2DSeqFilter[T] {
  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = axis match {
    case X => what.reverse
    case Y => what.map(_.reverse)
  }
}
