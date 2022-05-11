import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class UtilsTest {

   @Test
   fun `bps test`() {
       val a = 1000f
       val bps = 10L

       val result = a.basisPoints(bps)

       assertEquals(1f, result)

   }

}