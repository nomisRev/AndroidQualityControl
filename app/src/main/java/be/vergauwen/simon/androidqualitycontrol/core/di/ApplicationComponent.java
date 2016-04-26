package be.vergauwen.simon.androidqualitycontrol.core.di;

import android.content.Context;
import be.vergauwen.simon.androidqualitycontrol.core.rx.Transformers;
import be.vergauwen.simon.androidqualitycontrol.core.service.GithubAPI;
import dagger.Component;

@ApplicationScope
@Component(modules = {ApplicationModule.class,ServiceModule.class})
public interface ApplicationComponent {
    Context getApplicationContext();
    Transformers getTransfomers();
    GithubAPI getGithubAPI();
}