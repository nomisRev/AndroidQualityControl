package be.vergauwen.simon.androidqualitycontrol.core.service;

import be.vergauwen.simon.androidqualitycontrol.core.model.GitHubRepo;
import java.util.List;
import retrofit2.http.GET;
import rx.Observable;

public interface GithubAPI {
    @GET("/users/google/repos")
    Observable<List<GitHubRepo>> getRepos();
}
