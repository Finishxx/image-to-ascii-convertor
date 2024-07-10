package filters

trait Filter[T] {
  def filter(what: T): T

}
