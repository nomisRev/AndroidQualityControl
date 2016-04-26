package be.vergauwen.simon.androidqualitycontrol.ui;

import be.vergauwen.simon.androidqualitycontrol.core.model.GitHubRepo;
import be.vergauwen.simon.androidqualitycontrol.core.rx.Transformers;
import be.vergauwen.simon.androidqualitycontrol.core.service.GithubAPI;
import be.vergauwen.simon.himurakotlin.MVPPresenter;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class ExamplePresenter extends MVPPresenter<ExampleContract.View>
    implements ExampleContract.Presenter<ExampleContract.View> {

    private GithubAPI githubAPI;
    private Transformers transformers;

    @Inject
    public ExamplePresenter(GithubAPI githubAPI, Transformers transformers) {
        this.githubAPI = githubAPI;
        this.transformers = transformers;
    }

    @Override
    public void getRepos() {

        githubAPI.getRepos()
            .flatMap(new Func1<List<GitHubRepo>, Observable<GitHubRepo>>() {
                @Override
                public Observable<GitHubRepo> call(List<GitHubRepo> gitHubRepos) {
                    return Observable.from(gitHubRepos);
                }
            })
            .compose(transformers.<GitHubRepo>applyIOSchedulers())
            .filter(new Func1<GitHubRepo, Boolean>() {
                @Override
                public Boolean call(GitHubRepo gitHubRepo) {
                    return gitHubRepo != null;
                }
            })
            .subscribe(new Subscriber<GitHubRepo>() {
                @Override
                public void onCompleted() {}

                @Override
                public void onError(Throwable e) {
                    getView().showError();
                }

                @Override
                public void onNext(GitHubRepo gitHubRepo) {
                    getView().printRepo(gitHubRepo.getName());
                }
            });
    }
}
