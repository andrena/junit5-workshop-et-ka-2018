# Hamcrest und AssertJ

Mit JUnit 5 wird Hamcrest aus JUnit entfernt, daher muss dies jetzt als Abhänigkeit eingebunden werden.

```groovy
testImplementation "org.assertj:assertj-core:3.8.0"
testImplementation "org.hamcrest:hamcrest-all:1.3"

```