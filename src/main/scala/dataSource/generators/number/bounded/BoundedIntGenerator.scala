package dataSource.generators.number.bounded

import dataSource.generators.number.IntGenerator

/**
 * Generates Ints in a certain range
 * @param from Inclusive start of range
 * @param to Inclusive start of range
 */
abstract class BoundedIntGenerator(from: Int, to: Int) extends IntGenerator {

  protected def generateWithBounds(from: Int, to: Int): Int

  override def provide(): Int = generateWithBounds(from, to)
}
