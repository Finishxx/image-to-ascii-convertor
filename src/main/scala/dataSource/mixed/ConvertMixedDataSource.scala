package dataSource.mixed

import converters.Converter
import dataSource.DataSource

class ConvertMixedDataSource[T, V](
  source: DataSource[T],
  converter: Converter[T, V])
    extends DataSource[V] {
  override def provide(): V = converter.convert(source.provide())
}
