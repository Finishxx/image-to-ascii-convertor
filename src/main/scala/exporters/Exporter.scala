package exporters

trait Exporter[T] {

  def export(what: T): Unit
}
