# Android Quality Control

To increase and track the quality of your code there are serveral tools available. Aside from continuous integration (CI) tools like Jenkins and test coverage with Jacoco shown in <a href="https://github.com/nomisRev/AndroidGradleJacoco">Android Jacoco Gradle</a>, there are some static code analysis tools out there like <a href="https://pmd.github.io/">PMD</a>, <a href="http://findbugs.sourceforge.net/">FindBugs</a> and <a href="http://checkstyle.sourceforge.net/">Checkstyle</a>

##### Static code analysis
> Static program analysis is the analysis of computer software that is performed without actually executing programs (analysis performed on executing programs is known as dynamic analysis). In most cases the analysis is performed on some version of the source code, and in the other cases, some form of the object code.

In other words, it is a tool that is going to analyse our code and point out bugs, mistakes, pitfalls. **This is a tool and so it doens't work miracles!**

You can expect it to point out unused code, redudant code, unchecked potetional NPE's etc

## PMD
* PMD is a source code analyser. That means it analyses your source code to find missing curly braces, redundant null check, long parameter list, unnecessary constructor, missing break in switch, etc. What it should report is configureable, more about this below.
* PMD includes CPD (copy-paste-detector) which detects duplicated code.





## FindBugs
* FindBugs is a bytecode analyser.FindBugs will thus analyse the compiled `.class` files.
* FindBugs will search for common pitfalls in the compiled class files like infinite loops,  reference comparison of Boolean values, equals() method fails on subtypes, clone method may return null, (32bit) int shifted by an amount not in the range (of 0-31), a collection which contains itself, equals method always returns true, etc.



## Checkstyle
* Checkstyle is a development tool to help programmers write Java code that adheres to a coding standard. Eventhough this might seem minor, adhering the same code style throughout a project can drastically increase readability and thus the quality of your code.


## Source
* https://pmd.github.io/
* http://findbugs.sourceforge.net/
* http://checkstyle.sourceforge.net/
* https://docs.gradle.org/current/userguide/findbugs_plugin.html
* https://docs.gradle.org/current/userguide/pmd_plugin.html
* https://docs.gradle.org/current/userguide/checkstyle_plugin.html
