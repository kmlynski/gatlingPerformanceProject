package test.scala.main.consumables


import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

trait BaseRequest {
        def buildHttpConfiguration(): HttpProtocolBuilder = {
                http
                  .baseUrl(env.url)
                  .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
        }
}
