package dataSource.generators.number.bounded

import dataSource.generators.number.IntGenerator

abstract class BoundedIntGenerator(from: Int, to: Int) extends IntGenerator {

  protected def generateWithBounds(from: Int, to: Int): Int

  override def provide(): Int = generateWithBounds(from, to)
}
