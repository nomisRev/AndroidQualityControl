package be.vergauwen.simon.androidqualitycontrol.ui

class MockExampleView() : ExampleContract.View {
  var printedRepo = false
  var errorShown = false

  override fun printRepo(repoName: String) {
    printedRepo = true
  }

  override fun showError() {
    errorShown = true
  }
}