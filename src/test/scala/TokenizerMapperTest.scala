import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mrunit.mapreduce.MapDriver
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TokenizerMapperTest extends AnyFlatSpec with Matchers {

  "TokenizerMapper" should "correctly tokenize sentences" in {
    val mapper = new TokenizerMapper
    val mapDriver = new MapDriver[LongWritable, Text, Text, Text]()

    mapDriver.setMapper(mapper)

    // Test input
    val input = new Text("Hello world! This is a test.")
    mapDriver.withInput(new LongWritable(1), input)

    // Expected tokenized output
    val expectedToken1 = "Hello world!"
    val expectedTokens1 = "116 101 108 108 111"

    mapDriver.withOutput(new Text(expectedToken1), new Text(expectedTokens1))

    // Execute test
    mapDriver.runTest()
  }
}