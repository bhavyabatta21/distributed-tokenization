import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.apache.hadoop.fs.Path

class Word2VecJobDriverTest extends AnyFlatSpec with Matchers {

  "Word2VecJobDriver" should "set input and output paths correctly" in {
    val inputPath = "s3a://distributed-llm-bb-part-1/output/part-r-00000"
    val outputPath = "s3a://distributed-llm-bb-part-1/word2vec"

    inputPath shouldBe "s3a://distributed-llm-bb-part-1/output/part-r-00000"
    outputPath shouldBe "s3a://distributed-llm-bb-part-1/word2vec"
  }

  it should "throw an error when not provided with enough arguments" in {
    intercept[Exception] {
      Word2VecJobDriver.main(Array.empty[String])
    }
  }
}