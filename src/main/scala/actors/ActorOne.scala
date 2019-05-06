package actors

import akka.actor.{Actor, ActorRef}

class ActorOne(other: ActorRef) extends Actor {
  override def receive: Receive = {
    case i: Int =>
      if (i < 10) {
        println(self + " received " + i)
        println(self + " is sending " + (i + 1))
        other ! i + 1
      } else {
        println("Stopping " + self + "and " + other)
        context.stop(self)
        context.stop(other)
      }
    case _ => context.stop(self)
  }
}
