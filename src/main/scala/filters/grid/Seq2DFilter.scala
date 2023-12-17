package filters.grid

import filters.Filter
import grid.Grid

trait Seq2DFilter[T] extends Filter[Seq[Seq[T]]]
