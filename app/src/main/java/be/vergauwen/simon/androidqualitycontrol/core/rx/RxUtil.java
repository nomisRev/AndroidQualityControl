package be.vergauwen.simon.androidqualitycontrol.core.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxUtil implements Transformers {
    @Override
    public <T> Observable.Transformer<T, T> applyComputationSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.computation());
            }
        };
    }

    @Override
    public <T> Observable.Transformer<T, T> applyIOSchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io());
            }
        };
    }
}
