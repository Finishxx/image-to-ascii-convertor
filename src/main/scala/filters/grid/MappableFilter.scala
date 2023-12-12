package filters.grid

import filters.Filter

trait MappableFilter[T <: { def map[V](fun: T => V): V }] extends Filter[T] {

}
