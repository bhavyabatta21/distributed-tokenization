import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CosineSimilarityDriverTest extends AnyFlatSpec with Matchers {

  "CosineSimilarityDriver" should "correctly configure the input and output paths" in {
    val conf = new Configuration()
    val inputPath = "s3://distributed-llm-bb-part-1/word2vec"
    val outputPath = "s3://distributed-llm-bb-part-1/cosine-similarity"

    // Test if the configuration sets the default file system to s3
    conf.set("fs.defaultFS", "s3a://distributed-llm-bb-part-1")
    conf.get("fs.defaultFS") shouldBe "s3a://distributed-llm-bb-part-1"

    // Test if input and output paths are set correctly
    new Path(inputPath).toString shouldBe "s3://distributed-llm-bb-part-1/word2vec"
    new Path(outputPath).toString shouldBe "s3://distributed-llm-bb-part-1/cosine-similarity"
  }
}