import com.apsl.glideapp.common.util.capitalized
import com.apsl.glideapp.common.util.format
import java.util.Locale
import kotlin.test.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested

class KotlinUtilsTest {

    @Nested
    inner class StringCapitalizedTest {

        @Test
        fun `Check if lowercase string is capitalized correctly`() {
            val string = "foobar"
            val expected = "Foobar"
            val actual = string.capitalized()
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if uppercase string remains unchanged`() {
            val string = "Foobar"
            val expected = "Foobar"
            val actual = string.capitalized()
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if string that does not start with a letter remains unchanged`() {
            val string = "_foobar"
            val expected = "_foobar"
            val actual = string.capitalized()
            assertEquals(expected = expected, actual = actual)
        }
    }

    @Nested
    inner class DoubleFormatTest {

        @BeforeEach
        fun setUp() {
            Locale.setDefault(Locale.US)
        }

        @Test
        fun `Check if double is formatted correctly`() {
            val double = 123.45
            val expected = "123.45"
            val actual = double.format(2)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if double is formatted correctly with less 'digits'`() {
            Locale.setDefault(Locale.US)
            val double = 123.45
            val expected = "123.5"
            val actual = double.format(1)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if double is formatted correctly with more 'digits'`() {
            val double = 123.45
            val expected = "123.450"
            val actual = double.format(3)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if double is formatted correctly if 'digits' is 0`() {
            val double = 123.45
            val expected = "123"
            val actual = double.format(0)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if double is formatted correctly if 'digits' is negative`() {
            val double = 123.45
            val expected = "123"
            val actual = double.format(-1)
            assertEquals(expected = expected, actual = actual)
        }

        @Test
        fun `Check if double is formatted correctly depending on default locale`() {
            val double = 123.45

            var expected = "123.45"
            var actual = double.format(2)
            assertEquals(expected = expected, actual = actual)

            Locale.setDefault(Locale.FRANCE)
            expected = "123,45"
            actual = double.format(2)
            assertEquals(expected = expected, actual = actual)
        }
    }
}
