package filters.mixed

import filters.Filter

abstract class MixedFilter[T](filters: Seq[Filter[T]]) extends Filter[T] {

  override def filter(what: T): T =
    filters.foldLeft(what)((acc: T, filter: Filter[T]) => filter.filter(acc))

}
