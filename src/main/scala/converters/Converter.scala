package converters

/**
 * Converts type T onto type V
 *
 * @tparam T Type being converted
 * @tparam V Type which is being converted to
 */
trait Converter[T, V] {

  /**
   * Converts an item
   *
   * @param what What is being converted
   * @return Result of conversion
   */
  def convert(what: T): V

}
