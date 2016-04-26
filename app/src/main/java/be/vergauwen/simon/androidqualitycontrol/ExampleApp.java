package be.vergauwen.simon.androidqualitycontrol;

import android.app.Application;
import be.vergauwen.simon.androidqualitycontrol.core.di.ApplicationComponent;
import be.vergauwen.simon.androidqualitycontrol.core.di.ApplicationModule;
import be.vergauwen.simon.androidqualitycontrol.core.di.DaggerApplicationComponent;
import be.vergauwen.simon.androidqualitycontrol.core.di.ServiceModule;

public class ExampleApp extends Application {
    private  ApplicationComponent component;

    public ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
    }

    ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
            .applicationModule(new ApplicationModule(this))
            .serviceModule(new ServiceModule())
            .build();
    }
}
