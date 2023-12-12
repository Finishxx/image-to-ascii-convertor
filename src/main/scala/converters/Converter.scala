package converters

trait Converter[T, V] {

  def convert(what: T): V

}
