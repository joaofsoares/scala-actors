import actors.{ActorOne, ActorTwo}
import akka.actor.{ActorSystem, Props}

object Main extends App {

  val system = ActorSystem("ActorSystem")

  val actorTwo = system.actorOf(Props[ActorTwo], name = "ActorTwo")
  val actorOne = system.actorOf(Props(new ActorOne(actorTwo)), name = "ActorOne")

  actorOne ! 1

  system.terminate()

}
