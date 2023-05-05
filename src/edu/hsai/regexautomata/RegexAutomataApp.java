package edu.hsai.regexautomata;

import edu.hsai.regexautomata.state.State;

public class RegexAutomataApp {
    public static void main(String[] args) throws Exception {
        State q2 = State.buildState()
                .setId("q2")
                .makeFinal()
                .build();

        State q1 = State.buildState()
                .setId("q1")
                .connectToItself('c')
                .connectTo(q2, 'b')
                .build();

        String word = "cat";
        RegexAutomata ra = new RegexAutomata(q1, word);

        System.out.println(ra.nextState(word.charAt(0)));
    }
}
