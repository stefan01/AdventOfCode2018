package days

object Day01 extends Day {
  def part1(input: Iterator[String]) = {
    val result = input.map(_.toInt).sum
    println("Resulting frequency is: " + result)
  }

  def part2(input: Iterator[String]) = {
    val frequencyChangesList = input.map(_.toInt).toList

    def frequencyChangesStreamFunc: Stream[Int] = frequencyChangesList.toStream #::: frequencyChangesStreamFunc
    val frequencyChangesStream = frequencyChangesStreamFunc

    val frequenciesWithIndex =
      Stream.iterate((0, 0)) {
        case (frequency, index) => (frequency + frequencyChangesStream(index), index+1)
      }

    val frequencies = frequenciesWithIndex.map(_._1)

    val firstDoubleValue =
      frequenciesWithIndex find {
        case (frequency, index) => {
          println(s"Step: $index, Frequency: $frequency")
          frequencies.take(index).contains(frequency)
        }
      }

    println("First double frequency is: " + firstDoubleValue.get._1)
  }
}
