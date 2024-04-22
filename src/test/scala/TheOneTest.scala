import org.scalatest.funsuite.AnyFunSuite
import org.unb.theone.WordCounter

import scala.collection.immutable.{Set, Map}

class TheOneTest extends AnyFunSuite {
  test("Should filter non-word chars and replace them with a space") {
    assert(
      WordCounter.filterChars(
        "tEst. lots of different!WOrds\nnewline"
      ) == "tEst lots of different WOrds newline"
    )
  }

  test("Should normalize, make it all lowercase") {
    assert(WordCounter.normalize("NOT_AlL UPPer! :)") == "not_all upper! :)")
  }

  test("Should scan, split the raw text into an array of words") {
    assert(
      WordCounter
        .scan("word1 word2 word3")
        .sameElements(List("word1", "word2", "word3"))
    )
  }

  test("Should remove all stop words, the ones we don't care") {
    assert(
      WordCounter
        .removeStopWords(
          List("w1", "w2", "w3", "w4"),
          Set("w2", "w4")
        )
        .sameElements(List("w1", "w3"))
    )
  }

  test("Should correctly map how many words there are") {
    assert(
      WordCounter
        .frequencies(
          List("w1", "w2", "w3", "w1", "w3", "w3", "w3")
        ) == Map("w1" -> 2, "w2" -> 1, "w3" -> 4)
    )
  }

  test("Should sort the most common words") {
    assert(
      WordCounter
        .sortFreq(
          Map("w1" -> 2, "w2" -> 1, "w3" -> 4)
        ) == List(("w3", 4), ("w1", 2), ("w2", 1))
    )
  }

  test("Should get the most frequent words from an ordered list") {
    assert(
      WordCounter
        .topFreqs(
          List(("w3", 4), ("w1", 2), ("w2", 1)), 2
        ) == "w3 - 4\nw1 - 2\n"
    )
  }
}
