import org.scalatest.FlatSpec

class TimeSpec extends FlatSpec {

  "Formatting" should "create a beautified time representation" in {
    val hours = 5
    val minutes = 0
    val seconds = 59
    val expected = "05:00:59"
    val result = "%02d:%02d:%02d".format(hours, minutes, seconds)
    assertResult(expected)(result)
  }
}
