import com.pontotest.utils.basisPoints
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UtilsTest {

   @Test
   fun `bps test`() {
       val a = 1000f
       val bps = 10L

       val result = a.basisPoints(bps)

       assertEquals(1f, result)

   }

}