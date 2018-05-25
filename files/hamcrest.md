# Hamcrest und AssertJ

Mit JUnit 5 wird Hamcrest aus JUnit entfernt, daher muss dies jetzt als Abhängigkeit eingebunden werden.

```groovy
testImplementation "org.assertj:assertj-core:3.8.0"
testImplementation "org.hamcrest:hamcrest-core:1.3"

```