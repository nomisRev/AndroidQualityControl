package be.vergauwen.simon.androidqualitycontrol.core.service

import be.vergauwen.simon.androidqualitycontrol.core.model.GitHubRepo
import rx.Observable

class MockGithubAPI() : GithubAPI {

  val repos : List<GitHubRepo>
  var throwError = false

  init{
    val githubRepo = GitHubRepo()
    githubRepo.name = "test"
    githubRepo.url = "www.test.com"
    githubRepo.description = "test_desc"
    repos = listOf(githubRepo)
  }

  override fun getRepos(): Observable<List<GitHubRepo>> {
    return if (throwError) Observable.error(Exception("exception")) else Observable.just(repos)
  }
}