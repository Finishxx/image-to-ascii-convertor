package exporters

// Taken from example semester work by Martin Drozdík
trait Exporter[T] {

  def export(what: T): Unit
}
