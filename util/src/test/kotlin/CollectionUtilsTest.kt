import com.apsl.glideapp.common.util.compress
import com.apsl.glideapp.common.util.dropEvery
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import org.junit.jupiter.api.Nested

class CollectionUtilsTest {

    @Nested
    inner class DropEveryTest {

        private val testList = listOf("a", "b", "c", "d", "e", "f", "g", "h")

        @Test
        fun `Check if ordinary collection is transformed correctly`() {
            val expected = listOf("a", "b", "d", "e", "g", "h")
            val actual = testList.dropEvery(3)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if empty collection is transformed correctly`() {
            val expected = emptyList<String>()
            val actual = emptyList<String>().dropEvery(2)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if collection of 1 element is transformed correctly`() {
            val expected = listOf("a")
            val actual = listOf("a").dropEvery(2)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if collection of 2 elements is transformed correctly`() {
            val expected = listOf("a")
            val actual = listOf("a", "b").dropEvery(2)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if collection is transformed correctly if 'n' is 1`() {
            val expected = emptyList<String>()
            val actual = testList.dropEvery(1)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if collection is transformed correctly if 'n' is more than collection size`() {
            val expected = testList
            val actual = testList.dropEvery(testList.size + 1)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if transformation fails if the given 'n' is negative`() {
            assertFailsWith<IllegalArgumentException> { listOf("a").dropEvery(-1) }
        }
    }

    @Nested
    inner class CompressTest {

        @Test
        fun `Check if ordinary collection is compressed correctly`() {
            val testList = listOf("a", "b", "c", "d", "e", "f", "g", "h", "i")
            val actual = testList.compress(5)
            assertTrue { actual.size == 5 }
            assertTrue { actual.first() == testList.first() }
            assertTrue { actual.last() == testList.last() }
        }

        @Test
        fun `Check if collection with size less than 4 remains unchanged`() {
            val expected = listOf("a", "b")
            val actual = listOf("a", "b").compress(1)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if compression fails if the given 'n' is negative`() {
            assertFailsWith<IllegalArgumentException> { listOf("a").compress(-1) }
        }
    }
}
