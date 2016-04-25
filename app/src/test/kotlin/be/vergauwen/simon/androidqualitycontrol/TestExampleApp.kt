package be.vergauwen.simon.androidqualitycontrol

import be.vergauwen.simon.androidqualitycontrol.core.di.ApplicationComponent
import be.vergauwen.simon.androidqualitycontrol.core.di.DaggerApplicationComponent
import be.vergauwen.simon.androidqualitycontrol.core.di.TestApplicationModule
import be.vergauwen.simon.androidqualitycontrol.core.di.TestServiceModule

class TestExampleApp : ExampleApp() {
  override fun createComponent(): ApplicationComponent = DaggerApplicationComponent.builder().applicationModule(
      TestApplicationModule(this)).serviceModule(TestServiceModule()).build()
}