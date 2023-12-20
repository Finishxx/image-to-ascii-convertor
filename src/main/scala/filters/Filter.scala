package filters

trait Filter[T] {

  /**
   * Filters something
   *
   * @param what What to filter
   * @return Result of filtering
   */
  def filter(what: T): T

}
