package filters.grid

import filters.Filter


// Grid will be facaded by ascii
trait GridFilter[T] extends Filter[Seq[Seq[T]]]
