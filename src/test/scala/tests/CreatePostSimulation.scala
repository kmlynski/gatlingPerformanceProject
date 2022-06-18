package test.scala.tests

import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

class CreatePostSimulation extends Simulation with PostsRequests {

  val testScenario: ScenarioBuilder = scenario("Create post test")
    .feed(postDetails)
    .exec(addNewPost)
    .exec(getCommentsForGivenPost)
    .exec(getSinglePost)
    .exec(getAllPosts)
  private val postDetails = jsonFile(env.postDetailsFeed).random

  setUp(
    testScenario.inject(
      rampUsers(200).during(10)
    )
  ).protocols(buildHttpConfiguration())
}
