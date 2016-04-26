package be.vergauwen.simon.androidqualitycontrol.core.di

import be.vergauwen.simon.androidqualitycontrol.core.service.GithubAPI
import be.vergauwen.simon.androidqualitycontrol.core.service.MockGithubAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class TestServiceModule : ServiceModule() {

  @ApplicationScope
  @Provides
  override  fun provideGithubAPI(retrofit: Retrofit): GithubAPI {
    return MockGithubAPI()
  }
}