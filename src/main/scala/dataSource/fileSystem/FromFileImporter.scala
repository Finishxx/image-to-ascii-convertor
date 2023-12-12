package dataSource.fileSystem

import dataSource.DataSource

import java.io.File

abstract class FromFileImporter[T](file: File) extends DataSource[T] {

  protected def importFromFile(file: File): T

  override def provide(): T = importFromFile(file)
}
