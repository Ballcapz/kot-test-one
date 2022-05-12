import com.pontotest.main
import com.pontotest.parseArg
import com.pontotest.utils.TimeOfDay
import com.pontotest.utils.basisPoints
import com.pontotest.utils.getTimeOfDay
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.reflect.typeOf
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

    @Test
    fun `does it run`() {
        val result = main(listOf("arg1", "arg2").toTypedArray())

        assertEquals(Unit, result)
    }

    @Test
    fun `does it parse args`() {
        val result = main(listOf("--timeOfDay", "arg2").toTypedArray())

        assertEquals(Unit, result)
    }


    @Test
    fun `five am is Night`() {
        // 5 am, may 12, 2022 PDT
        val fiveAmTimestampMillis: Long = 1652356800000

        val result = getTimeOfDay(fiveAmTimestampMillis)

        assertEquals(TimeOfDay.NIGHT, result)
    }

    @Test
    fun `6 am is Morning`() {
        // 6 am, may 12, 2022 PDT
        val sixAmTimestampMillis: Long = 1652360400000

        val result = getTimeOfDay(sixAmTimestampMillis)

        assertEquals(TimeOfDay.MORNING, result)
    }


}