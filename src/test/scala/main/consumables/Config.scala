package test.scala.main.consumables

object Config {

        lazy val env: Environment = {
                initializeEnvironment()
        }

        def initializeEnvironment(): Environment = {
                val environment: String = System.getenv("enviro")

                environment match {
                        case "dev" => new Environment {
                                override val url: String = "https://jsonplaceholder.typicode.com"
                                override val postDetailsFeed: String = "./src/test/resources/environments/dev/postDetails.json"
                        }
                        case "prod" => new Environment {
                                override val url: String = "https://jsonplaceholder.typicode.com"
                                override val postDetailsFeed: String = "./src/test/resources/environments/prod/postDetails.json"
                        }
                        case _ => new Environment {
                                override val url: String = "https://jsonplaceholder.typicode.com"
                                override val postDetailsFeed: String = "./src/test/resources/environments/prod/postDetails.json"
                        }
                }
        }
}
