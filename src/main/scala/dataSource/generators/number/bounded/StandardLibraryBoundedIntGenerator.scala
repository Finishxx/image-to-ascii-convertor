package dataSource.generators.number.bounded

import scala.util.Random

/**
 * Uses standard Random library to generate random bounded Ints
 */
class StandardLibraryBoundedIntGenerator(from: Int, to: Int)
    extends BoundedIntGenerator(from, to) {
  require(from <= to, "From should always be smaller than to!")
  override protected def generateWithBounds(from: Int, to: Int): Int =
    Random.between(from, to + 1)
}
