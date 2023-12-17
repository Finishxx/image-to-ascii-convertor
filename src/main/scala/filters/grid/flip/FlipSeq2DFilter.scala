package filters.grid.flip

import filters.grid.Seq2DFilter
import Axis._

class FlipSeq2DFilter[T](axis: Axis) extends Seq2DFilter[T] {
  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = axis match {
    case X => what.reverse
    case Y => what.map(_.reverse)
  }
}
