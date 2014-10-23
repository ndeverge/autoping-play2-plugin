package com.github.ndeverge.autoping

import play.api.Plugin
import play.Logger
import play.api.libs.concurrent.Akka
import play.api.Application
import akka.actor.Props
import scala.concurrent.duration.DurationInt
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import akka.actor.Actor
import play.api.libs.ws.WS
import java.text.SimpleDateFormat
import java.util.Date
import play.api.Play.current

class Autoping(app: Application) extends Plugin {

  override def onStart() = {

    Logger.info("Loading Autoping plugin...")

    play.api.Play.mode(app) match {
      case play.api.Mode.Prod => {
        schedulePing()
      }
      case _ => // do not schedule anything for Test
    }
  }

  def schedulePing() = {

    app.configuration.getString("autoping.url").map {
      urlToPing =>
        Logger.info("Scheduling ping on " + urlToPing)
        val pingActor = Akka.system(app).actorOf(Props(new PingActor(urlToPing)))
        Akka.system(app).scheduler.schedule(0 seconds, 10 minutes, pingActor, "ping")
    }.getOrElse(Logger.error("""
        Autoping not started: please add 'autoconf.url' in your conf file !
        Example: autoconf.url = "http://localhost:9000/"
        """))
  }

}

class PingActor(url: String) extends Actor {

  def receive = {
    case _ => {
      WS.url(url).get.map(response => {
        val now = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date())
        Logger.info(now + ": ping status: " + response.status)
      })
    }
  }

}