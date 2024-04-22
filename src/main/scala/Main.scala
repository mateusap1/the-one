package org.unb.theone

import scala.io.Source
import scala.collection.immutable.{Set, Map}

sealed trait TheOneData

case class TheOneRaw(raw: String) extends TheOneData
case class TheOneWords(words: List[String]) extends TheOneData
case class TheOneWordsMap(wordsMap: Map[String, Int]) extends TheOneData
case class TheOneWordsFlatten(wordsFlatten: List[(String, Int)])
    extends TheOneData

class TheOne(var value: TheOneData) {
  def bind[A <: TheOneData, B <: TheOneData](f: A => B): TheOne = {
    value = f(value.asInstanceOf[A])
    this
  }

  def printme = {
    value match {
      case TheOneRaw(raw) => println(raw)
      case TheOneWords(words) => println(words)
      case TheOneWordsMap(wordsMap) => println(wordsMap)
      case TheOneWordsFlatten(wordsFlatten) => println(wordsFlatten)
    }
  }
}

object WordCounter {
  def readFile(path: TheOneRaw): TheOneRaw = {
    TheOneRaw(Source.fromFile(path.raw).mkString)
  }

  def filterChars(inputString: TheOneRaw): TheOneRaw = {
    TheOneRaw(inputString.raw.replaceAll("""[\W_]+""", " "))
  }

  def normalize(inputString: TheOneRaw): TheOneRaw = {
    TheOneRaw(inputString.raw.toLowerCase())
  }

  def scan(inputString: TheOneRaw): TheOneWords = {
    TheOneWords(inputString.raw.split(" ").toList)
  }

  def removeStopWords(inputWords: TheOneWords): TheOneWords = {
    val stopWordsPath =
      "/Users/mateusoliveirasantos/Documents/estudos/unb/tec_prog/code/the-one/data/stop_words.txt"
    val stopWords = Source.fromFile(stopWordsPath).getLines().toSet

    TheOneWords(inputWords.words.filter((s: String) => !stopWords.contains(s)))
  }

  def frequencies(inputWords: TheOneWords): TheOneWordsMap = {
    def addToMap(s: String, acc: Map[String, Int]) = {
      if (acc.contains(s)) {
        acc + (s -> (acc(s) + 1))
      } else {
        acc + (s -> 1)
      }
    }

    TheOneWordsMap(inputWords.words.foldRight(Map.empty[String, Int])(addToMap))
  }

  def sortFreq(frequencyWords: TheOneWordsMap): TheOneWordsFlatten = {
    TheOneWordsFlatten(
      frequencyWords.wordsMap.toList.sortBy[Int]((wordFreq: (String, Int)) =>
        -wordFreq._2
      )
    )
  }

  def topFreqs(ordFreqWords: TheOneWordsFlatten): TheOneRaw = {
    TheOneRaw(
      ordFreqWords.wordsFlatten
        .slice(0, 25)
        .foldRight("")((wordFreq: (String, Int), acc: String) =>
          wordFreq._1 + " - " + wordFreq._2.toString + "\n" + acc
        )
    )
  }
}

object Main extends App {
  val path =
    "/Users/mateusoliveirasantos/Documents/estudos/unb/tec_prog/code/the-one/data/pride-and-prejudice.txt"

  new TheOne(TheOneRaw(path))
    .bind(WordCounter.readFile(_))
    .bind(WordCounter.filterChars(_))
    .bind(WordCounter.normalize(_))
    .bind(WordCounter.scan(_))
    .bind(WordCounter.removeStopWords(_))
    .bind(WordCounter.frequencies(_))
    .bind(WordCounter.sortFreq(_))
    .bind(WordCounter.topFreqs(_))
    .printme
}
