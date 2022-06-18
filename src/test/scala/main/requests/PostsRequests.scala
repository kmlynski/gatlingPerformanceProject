package test.scala.main.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder

trait PostsRequests extends BaseRequest {

  val getAllPostsEndpoint: String = "/posts"
  val getSinglePostEndpoint: String = "/posts/${userId}"
  val getCommentsForGivenPostEndpoint: String = "/posts/${id}/comments"
  val postNewPostEndpoint: String = "/posts"

  def getAllPosts: HttpRequestBuilder = {
    http("Get All Posts")
      .get(getAllPostsEndpoint)
  }

  def getSinglePost: HttpRequestBuilder = {
    http("Get Single Post")
      .get(getSinglePostEndpoint)
  }

  def getCommentsForGivenPost: HttpRequestBuilder = {
    http("Get Comments For Given Post")
      .get(getCommentsForGivenPostEndpoint)
  }

  def addNewPost: HttpRequestBuilder = {
    http("Add New Post")
      .post(postNewPostEndpoint)
      .header("Content-type", "application/json")
      .check(status.is(201))
      .check(jsonPath("$.id").saveAs("id"))
  }
}
