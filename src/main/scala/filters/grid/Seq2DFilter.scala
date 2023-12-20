package filters.grid

import filters.Filter

/**
 * Filters Seq2Ds
 * @tparam T Type of elements stored inside Seq2D
 */
trait Seq2DFilter[T] extends Filter[Seq[Seq[T]]]
