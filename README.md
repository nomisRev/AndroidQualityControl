# Android Quality Control

To increase and track the quality of your code there are serveral tools available. Aside from continuous integration (CI) tools like Jenkins and test coverage with Jacoco shown in <a href="https://github.com/nomisRev/AndroidGradleJacoco">Android Jacoco Gradle</a>, there are some static code analysis tools out there like <a href="https://pmd.github.io/">PMD</a>, <a href="http://findbugs.sourceforge.net/">FindBugs</a> and <a href="http://checkstyle.sourceforge.net/">Checkstyle</a>

##### Static code analysis
> Static program analysis is the analysis of computer software that is performed without actually executing programs (analysis performed on executing programs is known as dynamic analysis). In most cases the analysis is performed on some version of the source code, and in the other cases, some form of the object code.

In other words, it is a tool that is going to analyse our code and point out bugs, mistakes, pitfalls. **This is a tool and so it doens't work miracles!**

You can expect it to point out unused code, redudant code, unchecked potetional NPE's etc

## PMD
* PMD is a source code analyser. That means it analyses your source code to find missing curly braces, redundant null check, long parameter list, unnecessary constructor, missing break in switch, etc. What it should report is configureable, more about this below.
* PMD includes CPD (copy-paste-detector) which detects duplicated code.

* Setting up PMD is relatively easy. The most important step here is to decide what you want PMD to check, and depending on these decisions you should setup your configuration.
* The documentation can be rather tedious, and unhelpfull to setup the PMD configuration in gradle. This is a list of the possible <a href="https://github.com/pmd/pmd/tree/83bb14e28e576eafa780bc0f6982b1a78b823c60/pmd/src/main/resources/rulesets/java">Ruleset</a> you can specify that PMD should analyse, the files linked here hold some documentation of what they do. More information can be found here <a href="http://pmd.sourceforge.net/pmd-4.3.0/rules/index.html">PMD Rules</a>. **Don't forget that in Gradle, the rules must be prefixed with the language. So in our case the ruleset resides in the java folde. So prefix with `java-`**

* Combining these sources you should be able to figure out what configuration suits your project, and your setup might look something like this.

```
apply plugin: 'pmd'

check.dependsOn 'pmd'

task pmd(type: Pmd) {

    description "Generate PMD reports for this build"

    ignoreFailures true    // Ignores failing build on warning. If not set build will fail on warning.

    ruleSets = [
        "java-basic",
        "java-braces",
        "java-naming",
        "java-android",
        "java-codesize",
        "java-design",
        "java-finalizers",
        "java-junit",
        "java-optimizations",
        "java-strictexception",
        "java-strings",
        "java-unusedcode"
    ]

    source 'src'          // Specify the source code. The script should be applied to
    include '**/*.java'   // the module build.gradle so the 'src' folder resides at the same level
    exclude '**/gen/**'   // include / exclude folders and files.
    
    reports {
        xml.enabled = true
        html.enabled = true
    }
}
```


## FindBugs
* FindBugs is a bytecode analyser.FindBugs will thus analyse the compiled `.class` files.
* FindBugs will search for common pitfalls in the compiled class files like infinite loops,  reference comparison of Boolean values, equals() method fails on subtypes, clone method may return null, (32bit) int shifted by an amount not in the range (of 0-31), a collection which contains itself, equals method always returns true, etc.
* FindBugs like PMD analyses your code and thus can be setup with a very minimal setup. FindBugs can also be configured with custom bugs, this setup is out of the scope of this article. More information on how to do this can be found <a href="http://findbugs.sourceforge.net/manual/filter.html#d0e1880">here</a>.

* A basic setup might look something like this
```
apply plugin: 'findbugs'

check.dependsOn 'findbugs'

task findbugs(type: FindBugs) {

    description 'Generate FindBugs reports for this build'

    ignoreFailures true

    //Higher levels increase precision and find more bugs at the expense of running time and memory consumption.
    effort = 'max'
    //The priority threshold for reporting bugs. If set to {@code low}, all bugs are reported.
    reportLevel = 'low'

    //Define path to classes
    classes = fileTree("${project.rootDir}/app/build/intermediates/classes") //path to compiled class files
    
    source 'src'          // Specify the source code. The script should be applied to
    include '**/*.java'   // the module build.gradle so the 'src' folder resides at the same level
    exclude '**/gen/**'   // include / exclude folders and files.

    //Define exclude config file
    excludeFilter = file("${rootProject.projectDir}/gradle/config/findbugs/exclude.xml")

    //IMPORTANT: FINDBUGS CAN ONLY GENERATE 1 REPORT. XML OR HTML!! AND PATH MUST BE DEFINED!!
    reports {
        xml.enabled = false
        html.enabled = true
        xml.destination = "$project.buildDir/reports/findbugs/findbugs-output.xml"
        html.destination = "$project.buildDir/reports/findbugs/findbugs-output.html"
    }

    classpath = files()
}
```

**A general `exclude.xml` file can be found in this repo. And it consists of a simple <match> <exclude> pattern to exclude files generated by the most common libraries like dagger, butterknife, kotlin, ... When using a library, you trust the developers code so this should not be included in the analysis**

## Checkstyle
* Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard. Eventhough this might seem minor, adhering the same code style throughout a project can drastically increase readability and thus the quality of your code.


## Source
* https://pmd.github.io/
* http://findbugs.sourceforge.net/
* http://checkstyle.sourceforge.net/
* https://docs.gradle.org/current/userguide/findbugs_plugin.html
* https://docs.gradle.org/current/userguide/pmd_plugin.html
* https://docs.gradle.org/current/userguide/checkstyle_plugin.html
* http://stackoverflow.com/questions/20710704/gradles-pmd-plugin-what-are-acceptable-arguments
