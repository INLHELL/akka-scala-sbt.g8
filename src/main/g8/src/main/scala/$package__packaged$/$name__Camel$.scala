package $package$

import akka.actor._
import scala.concurrent.duration._
import java.util.concurrent._

case object Tick
case object Get

class Counter extends Actor {
  var count = 0

  def receive = {
    case Tick => count += 1
    case Get  => sender ! count
  }
}

class Reporter(val printer: Any => Unit) extends Actor {
  def receive = {
    case (count) =>
      printer("Count:\t%s".format(count))
  }
}

class RunLoop extends Actor {
  import context.dispatcher

  val counter = context.actorOf(Props(classOf[Counter]))
  val reporter = context.actorOf(Props(classOf[Reporter], (msg: Any) => println(msg)))

  context.system.scheduler.schedule(1.second, 1.second, counter, Tick)
  context.system.scheduler.schedule(3.seconds, 3.seconds, counter, Get)(context.dispatcher, reporter)

  TimeUnit.SECONDS.sleep(10)
  context.system.terminate()

  def receive = {
    case _ =>
  }
}

object $name;format="Camel"$ extends App {

  akka.Main.main(Array("$package$.RunLoop"))

}
