(a) a code snippet showing an example of input validation.
Answer:
It is almost everywhere. Like Type Checking, Size Limitation, if-statement, etc.
E.g., in "BaseballPlayer.java", line 55-59. The function "validateAvgBattingScore()".
Using AVG_BATTING_SCORE_LIMIT to check avgBattingScore.



(b) In the same file Problem1.md include a code snippet showing inheritance.
Answer:
The class "Runner" and "BaseballPlayer" is subclasses of "Athlete". Using keyword "extends"
in line 9 
(public class BaseballPlayer extends Athlete{})
(public class Runner extends Athlete {})
in both BaseballPlayer.java and Runner.java.


(c) In the same file Problem1.md include a code snippet showing method overriding.
Answer:
Every equals(), hashCode() and toString() method in BaseballPlayer.java (from line 85 to the end) and in Runner.java
is overriding methods from the superclass Athlete.
E.g., in Runner.java, line 74. We can see "@Override" which means the equals() method is overriding from its superclass Athlete.




(d) In the same file Problem1.md include a code snippet showing casting.
Answer:
In Runner.java, line 74-89, 
" @Override
public boolean equals(Object o) {
if (this == o) {
return true;
}
if (o == null || getClass() != o.getClass()) {
return false;
}
if (!super.equals(o)) {
return false;
}
Runner runner = (Runner) o;
return Objects.equals(best5KTime, runner.best5KTime) && Objects.equals(
bestHalfMarathonTime, runner.bestHalfMarathonTime) && Objects.equals(
favoriteRunningEvent, runner.favoriteRunningEvent);
}",
the "Runner runner = (Runner) o;" is using downcasting.
This operation is necessary because the equals method is 
designed to accept an argument of type Object to maintain compatibility with all classes, 
given that Object is the superclass of all classes in Java.



(e) In the same file Problem1.md include a code snippet of method overloading.
Answer:
In Runner.java line 15-49, we can see two constructors with different parameters.
The first constructor includes a league parameter, while the second constructor omits this parameter.

