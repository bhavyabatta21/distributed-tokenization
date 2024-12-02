import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Reducer
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito

import scala.collection.JavaConverters._

class Word2VecReducerTest extends AnyFlatSpec with Matchers {

  "Word2VecReducer" should "write embeddings for tokens correctly" in {
    val reducer = new Word2VecReducer()
    val context = mock(classOf[Reducer[Text, Text, Text, Text]#Context])
    val key = new Text("1")
    val values = List(new Text("101,102,103")).asJava

    // Simulate context configuration
    when(context.getConfiguration).thenReturn(new Configuration())

    reducer.reduce(key, values, context)

    // Assuming the embeddings should be emitted properly
    verify(context, atLeastOnce()).write(any(classOf[Text]), any(classOf[Text]))
  }
}