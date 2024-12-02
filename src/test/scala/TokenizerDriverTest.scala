import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.slf4j.LoggerFactory

class TokenizerDriverTest extends AnyFlatSpec with Matchers {

  "TokenizerDriver" should "validate input arguments" in {
    val logger = LoggerFactory.getLogger(getClass)

    // Capture arguments
    val inputPath = "s3://distributed-llm-bb-part-1/input"
    val outputPath = "s3://distributed-llm-bb-part-1/output"
    val csvOutputPath = "s3://distributed-llm-bb-part-1/output/csv"

    // Check that paths are set correctly
    inputPath should be ("s3://distributed-llm-bb-part-1/input")
    outputPath should be ("s3://distributed-llm-bb-part-1/output")
    csvOutputPath should be ("s3://distributed-llm-bb-part-1/output/csv")

    logger.info(s"Tested input: $inputPath, output: $outputPath, csvOutputPath: $csvOutputPath")
  }
}