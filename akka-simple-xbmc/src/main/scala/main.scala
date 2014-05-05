import akka.actor.{ActorLogging, Actor, Props}

object GetPosition {
  var jsonrpc = "2.0"
  var id = 1
  var method = "Player.GetProperties"
  var params: Map[String, Any] = Map("properties" -> List("type", "time", "percentage"), "playerid" -> 0)
}

case class Position(percentage: Double, time: Time)

case class Time(hours: Int, minutes: Int, seconds: Int) {
  val label = if (hours == 0) "%02d:%02d".format(minutes, seconds) else "%02d:%02d:%02d".format(hours, minutes, seconds)
}

class MainActor extends Actor with ActorLogging {

  override def preStart() = {
    val xbmc = context.actorOf(Props[XBMCActor], "xbmc")
    xbmc ! GetPosition
  }

  def receive = {
    case Position(percentage, time) =>
      log.info(s"Percentage: $percentage, time: $time")
      context.stop(self)
  }
}

class XBMCActor extends Actor with ActorLogging {
  def receive = {
    case GetPosition =>
      log.info("Received request for current position")
      sender ! Position(0.5, Time(0, 2, 30))
  }
}