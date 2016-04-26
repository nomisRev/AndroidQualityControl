package be.vergauwen.simon.androidqualitycontrol.core.di;

import android.app.Application;
import android.content.Context;
import be.vergauwen.simon.androidqualitycontrol.core.rx.RxUtil;
import be.vergauwen.simon.androidqualitycontrol.core.rx.Transformers;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @ApplicationScope
    @Provides
    Context provideApplicationContext(){
        return application;
    }

    @ApplicationScope
    @Provides
    Transformers provideTransformers(){
        return new RxUtil();
    }
}
