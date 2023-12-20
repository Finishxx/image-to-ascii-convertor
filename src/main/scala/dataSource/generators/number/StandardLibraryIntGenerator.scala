package dataSource.generators.number

import scala.util.Random

/**
 * Uses standard Random library to generate random ints
 */
class StandardLibraryIntGenerator extends IntGenerator {
  override def provide(): Int = Random.nextInt()
}
