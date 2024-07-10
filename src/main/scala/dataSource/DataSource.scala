package dataSource

// Source of something
trait DataSource[T] {
  def provide(): T
}
