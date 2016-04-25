package be.vergauwen.simon.androidqualitycontrol.core.di

import android.app.Application
import android.content.Context
import be.vergauwen.simon.androidqualitycontrol.core.rx.MockRxUtil
import be.vergauwen.simon.androidqualitycontrol.core.rx.Transformers
import dagger.Module
import dagger.Provides

@Module
class TestApplicationModule(private val application: Application) : ApplicationModule(application) {

  @ApplicationScope
  @Provides
  override fun provideApplicationContext(): Context {
    return application
  }

  @ApplicationScope
  @Provides
  override fun provideTransformers(): Transformers {
    return MockRxUtil()
  }
}