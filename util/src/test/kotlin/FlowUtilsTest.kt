import app.cash.turbine.test
import com.apsl.glideapp.common.util.asResult
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest

class FlowUtilsTest {

    private val successFlow: Flow<String> = flow {
        emit("Foo")
        emit("Bar")
        emit("Foobar")
    }

    private val failingFlow: Flow<String> = flow {
        emit("Foo")
        throw Exception()
    }

    @Test
    fun `Check if 'success' flow is mapped to Result correctly`() = runTest {
        successFlow.asResult().test {
            assertTrue(awaitItem().getOrNull() == "Foo")
            assertTrue(awaitItem().getOrNull() == "Bar")
            assertTrue(awaitItem().getOrNull() == "Foobar")
            awaitComplete()
        }
    }

    @Test
    fun `Check if 'failing' flow is mapped to Result correctly`() = runTest {
        failingFlow.asResult().test {
            assertTrue(awaitItem().getOrNull() == "Foo")
            assertTrue(awaitItem().isFailure)
            awaitComplete()
        }
    }
}
