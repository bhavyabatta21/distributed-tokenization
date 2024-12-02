import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.apache.hadoop.io.{LongWritable, Text}
import org.apache.hadoop.mapreduce.Mapper
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.scalatestplus.mockito.MockitoSugar

class CosineSimilarityMapperTest extends AnyFlatSpec with Matchers with MockitoSugar {

  "CosineSimilarityMapper" should "load all tokens and embeddings during setup" in {
    val context = mock[Mapper[LongWritable, Text, Text, Text]#Context]
    val mapper = new CosineSimilarityMapper

    when(context.getConfiguration).thenReturn(new org.apache.hadoop.conf.Configuration())

    // Simulate setup phase
    mapper.setup(context)

    // Check that embeddings are loaded (mock logic to confirm non-zero size)
    mapper.allTokensAndEmbeddings.size should be > 0
  }

  it should "calculate cosine similarity correctly" in {
    val mapper = new CosineSimilarityMapper

    val vecA = Array(1.0, 2.0, 3.0)
    val vecB = Array(4.0, 5.0, 6.0)

    val similarity = mapper.calculateCosineSimilarity(vecA, vecB)

    // Expected cosine similarity for these vectors
    similarity should be(0.9746318461970762 +- 0.0001)
  }

  it should "classify cosine similarity values into correct classes" in {
    val mapper = new CosineSimilarityMapper

    mapper.classifyCosineSimilarity(0.1) should be ("A")
    mapper.classifyCosineSimilarity(0.3) should be ("B")
    mapper.classifyCosineSimilarity(0.6) should be ("C")
    mapper.classifyCosineSimilarity(0.9) should be ("D")
  }
}