package edu.hsai.regexautomata;

import edu.hsai.regexautomata.edge.Edge;
import edu.hsai.regexautomata.state.State;

import java.util.Set;

public class RegexAutomataApp {
    public static void main(String[] args) {
        State q2 = State.buildState()
                .setId("q2")
                .makeFinal()
                .build();

        State q1 = State.buildState()
                .setId("q1")
                .connectToItself(Set.of('a'))
                .connectTo(q2, Set.of('b'))
                .build();

        Edge.buildEdge().setDst(q1).setSrc(q2).setSignals(Set.of('a')).build();

        String word = "abab";
        System.out.println(new Analyzer(q1, word).isRegexed());
    }
}
