package dataSource.generators.number

import scala.util.Random

class StandardLibraryIntGenerator extends IntGenerator {
  override def provide(): Int = Random.nextInt()
}
