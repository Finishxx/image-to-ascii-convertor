package filters.grid.flip

import filters.grid.Seq2DFilter
import Axis._

/**
 * Flips Seq2D by given axis
 *
 * @param axis Axis to flip the Seq2D by
 * @tparam T Type of elements stored inside Seq2D
 */
class FlipSeq2DFilter[T](axis: Axis) extends Seq2DFilter[T] {
  override def filter(what: Seq[Seq[T]]): Seq[Seq[T]] = axis match {
    case X => what.reverse
    case Y => what.map(_.reverse)
  }
}
