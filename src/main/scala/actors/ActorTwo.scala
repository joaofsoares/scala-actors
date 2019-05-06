package actors

import akka.actor.Actor

class ActorTwo extends Actor {
  override def receive: Receive = {
    case i: Int =>
      println(self + " received " + i)
      println(self + " is sending " + (i + 1))
      sender ! i + 1
    case _ => context.stop(self)
  }
}
