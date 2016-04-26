package be.vergauwen.simon.androidqualitycontrol.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import be.vergauwen.simon.androidqualitycontrol.ExampleApp;
import be.vergauwen.simon.androidqualitycontrol.R;
import be.vergauwen.simon.himurakotlin.MVPDaggerActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleActivity
    extends MVPDaggerActivity<ExampleContract.View, ExamplePresenter, ExampleComponent>
    implements ExampleContract.View {

    private TextView githubRepo;

    @NotNull
    @Override
    protected ExampleComponent createComponent() {
        return DaggerExampleComponent.builder()
            .applicationComponent(((ExampleApp) getApplication()).getComponent())
            .build();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_activity);
        githubRepo = (TextView) findViewById(R.id.github_repos);
        githubRepo.setText("Github repo = \n");
    }

    @Override
    public void printRepo(String repoName) {
        Log.e("ExampleActivity", repoName);
        githubRepo.setText(githubRepo.getText().toString() + repoName + "\n");
    }

    @Override
    public void showError() {
        githubRepo.setText("error");
    }
}
