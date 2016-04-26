package be.vergauwen.simon.androidqualitycontrol.core.di;

import be.vergauwen.simon.androidqualitycontrol.BuildConfig;
import be.vergauwen.simon.androidqualitycontrol.core.service.GithubAPI;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

    @ApplicationScope
    @Provides
    Retrofit provideRestAdapter(){
        return new Retrofit.Builder().baseUrl(BuildConfig.URI).addConverterFactory(
            GsonConverterFactory.create()).addCallAdapterFactory(
            RxJavaCallAdapterFactory.create()).build();
    }

    @ApplicationScope
    @Provides
    GithubAPI provideGithubAPI(Retrofit retrofit){
        return retrofit.create(GithubAPI.class);
    }
}
