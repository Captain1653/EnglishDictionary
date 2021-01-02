import com.blogspot.captain1653.dictionary.scala.{DictionaryConfig, FilePathResolver, QuestionStrategyType, WordsOrder}
import org.scalatest.funsuite.AnyFunSuite

class FilePathsResolverSuite extends AnyFunSuite {

  test("get absolute file paths from folder") {
    val dictionaryConfig = DictionaryConfig(
      WordsOrder.RANDOM,
      QuestionStrategyType.RUSSIAN,
      "src/test/resources/filePathResolver/getAllFiles/",
      Array("*")
    )
    val paths = new FilePathResolver(dictionaryConfig).absoluteFilePaths

    assert(2 == paths.length)
    assert("src/test/resources/filePathResolver/getAllFiles/one.txt" == paths(0))
    assert("src/test/resources/filePathResolver/getAllFiles/two.txt" == paths(1))
  }

  test("get only specified files") {
    val dictionaryConfig = DictionaryConfig(
      WordsOrder.RANDOM,
      QuestionStrategyType.RUSSIAN,
      "dd",
      Array("src/test/resources/filePathResolver/onlySpecifiedFiles/specifiedOne.txt")
    )
    val paths = new FilePathResolver(dictionaryConfig).absoluteFilePaths

    assert(1 == paths.length)
    assert("src/test/resources/filePathResolver/onlySpecifiedFiles/specifiedOne.txt" == paths(0))
  }
}
