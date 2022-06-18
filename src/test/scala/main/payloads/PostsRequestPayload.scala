package test.scala.main.payloads

import io.gatling.core.Predef._
import io.gatling.core.body.StringBody

object PostsRequestPayload {
  val postsBody: StringBody = StringBody(
    """{
      | "body": "${body}"
      | "id": "${id}"
      | "title": "${title}"
      | "userId": "${userId}"
      |}""".stripMargin
  )
}