package be.vergauwen.simon.androidqualitycontrol.ui;

import be.vergauwen.simon.himurakotlin.MVPContract;

public interface ExampleContract {
    interface View extends MVPContract.View {
        void printRepo(String repoName);
        void showError();
    }

    interface Presenter<V extends MVPContract.View> extends MVPContract.Presenter<V> {
        void getRepos();
    }

    interface Component<V extends MVPContract.View, P extends MVPContract.Presenter<V>> extends MVPContract.Component<V, P>{}
}
