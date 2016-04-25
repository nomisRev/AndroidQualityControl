package be.vergauwen.simon.androidqualitycontrol.ui

import be.vergauwen.simon.androidqualitycontrol.core.di.ActivityScope
import be.vergauwen.simon.androidqualitycontrol.core.di.ApplicationComponent
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ExampleComponent : ExampleContract.Component<ExampleContract.View,ExamplePresenter>