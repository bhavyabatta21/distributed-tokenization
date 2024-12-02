import org.apache.hadoop.io.Text
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import play.api.libs.json.Json

import scala.collection.JavaConverters._

class TokenizerReducerTest extends AnyFlatSpec with Matchers {

  "TokenizerReducer" should "correctly aggregate tokenized sentences and convert to JSON" in {
    val reducer = new TokenizerReducer
    val reduceDriver = new ReduceDriver[Text, Text, Text, Text]()

    reduceDriver.setReducer(reducer)

    // Mock data for tokenized sentences
    val key = new Text("SentenceKey")
    val tokenizedValues = List(
      new Text("100 101 102"),
      new Text("103 104 105")
    ).asJava

    // Add input to the reduce driver
    reduceDriver.withInput(key, tokenizedValues)

    // Expected JSON output
    val expectedJson = Json.stringify(Json.arr(
      Json.arr(100, 101, 102),
      Json.arr(103, 104, 105)
    ))

    reduceDriver.withOutput(null, new Text(expectedJson))

    // Run the test
    reduceDriver.runTest()
  }
}