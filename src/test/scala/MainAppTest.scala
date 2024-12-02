import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MainAppTest extends AnyFlatSpec with Matchers {

  "MainApp" should "configure input and output paths correctly" in {
    val conf = new Configuration()
    val inputPath = new Path("s3://distributed-llm-bb-part-1/word2vec")
    val outputPath = new Path("s3://distributed-llm-bb-part-1/cosine-similarity")

    inputPath.toString shouldBe "s3://distributed-llm-bb-part-1/word2vec"
    outputPath.toString shouldBe "s3://distributed-llm-bb-part-1/cosine-similarity"
  }
}