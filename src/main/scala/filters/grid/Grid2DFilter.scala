package filters.grid

import filters.Filter


// Grid will be facaded by ascii
trait Grid2DFilter[T] extends Filter[Seq[Seq[T]]]
