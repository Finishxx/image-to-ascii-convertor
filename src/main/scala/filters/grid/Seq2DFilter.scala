package filters.grid

import filters.Filter

trait Seq2DFilter[T] extends Filter[Seq[Seq[T]]]
