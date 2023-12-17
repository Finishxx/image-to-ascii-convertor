package converters.deleteOrNot

import converters.Converter

abstract class Grid2DConverter[T, V](converter: Converter[T, V])
    extends Converter[Seq[Seq[T]], Seq[Seq[V]]] {

  override def convert(what: Seq[Seq[T]]): Seq[Seq[V]] =
    what.map(_.map(converter.convert))
}
