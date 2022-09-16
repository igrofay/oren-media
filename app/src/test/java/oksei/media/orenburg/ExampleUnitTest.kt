package oksei.media.orenburg
import oksei.media.orenburg.domain.model.NewsEvent
import oksei.media.orenburg.domain.types.NewsType
import org.junit.Test
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import oksei.media.orenburg.domain.types.DateType
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        println(
            Json.encodeToString(Tupe.AllTime)
        )

    }
    @Serializable
    enum class Tupe{
        AllTime
    }
}