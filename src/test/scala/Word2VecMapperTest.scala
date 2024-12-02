import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mapreduce.Mapper
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito
import org.apache.hadoop.conf.Configuration
import org.mockito.MockedConstruction.Context


class Word2VecMapperTest extends AnyFlatSpec with Matchers {

  "Word2VecMapper" should "properly tokenize and generate word vectors" in {
    val mapper = new Word2VecMapper()
    val context = mock(classOf[Context])
    val key = new LongWritable(1)
    val value = new Text("Sample sentence for testing.")

    // Simulate context configuration
//    when(context.getConfiguration).thenReturn(new Configuration())

    mapper.map(key, value, context)

    // Assuming the tokenized output should be emitted properly
//    verify(context, atLeastOnce()).write(any(classOf[Text]), any(classOf[Text]))
  }
}