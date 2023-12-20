package dataSource

/**
 * Source of some data
 *
 * @tparam T Type of provided data
 */
trait DataSource[T] {

  def provide(): T
}
