package be.vergauwen.simon.androidqualitycontrol.core.rx;

import rx.Observable;

public interface Transformers {
    <T> Observable.Transformer<T, T> applyComputationSchedulers();
    <T> Observable.Transformer<T, T> applyIOSchedulers();
}