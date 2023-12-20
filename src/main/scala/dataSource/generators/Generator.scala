package dataSource.generators

import dataSource.DataSource

/**
 * Generator of some data
 *
 * @tparam T Type of provided data
 */
trait Generator[T] extends DataSource[T]
