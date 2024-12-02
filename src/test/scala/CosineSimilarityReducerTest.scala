import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.MockitoSugar


class CosineSimilarityReducerTest extends AnyFlatSpec with Matchers with MockitoSugar {

  "CosineSimilarityReducer" should "collect all values for a key and emit each result" in {
    val context = mock[Reducer[Text, Text, Text, Text]#Context]
    val reducer = new CosineSimilarityReducer

    val key = new Text("token1")
    val values = java.util.Arrays.asList(new Text("token2 0.9 D"), new Text("token3 0.7 C"))

    // Call the reduce function
    reducer.reduce(key, values, context)

    // Verify context write calls
    verify(context, times(1)).write(key, new Text("token2 0.9 D"))
    verify(context, times(1)).write(key, new Text("token3 0.7 C"))
  }
}