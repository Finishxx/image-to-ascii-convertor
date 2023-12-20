package dataSource.fileSystem

import dataSource.DataSource

import java.io.File

/**
 * Imports data from a File
 *
 * @param file File containing the data
 * @tparam T Type of provided data
 */
abstract class FromFileImporter[T](file: File) extends DataSource[T] {

  protected def importFromFile(file: File): T

  override def provide(): T = importFromFile(file)
}
