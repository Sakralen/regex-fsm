package edu.hsai.regexautomata;

import edu.hsai.regexautomata.finiteautomata.Edge;
import edu.hsai.regexautomata.finiteautomata.State;

import java.util.Set;

public class RegexAutomata {
    private final State entryState;

    public RegexAutomata() {
        State q1 = State.buildState()
                .setId("q1")
                .connectToItself(Set.of('a'))
                .build();

        entryState = q1;

        State q2 = State.buildState()
                .setId("q2")
                .makeFinal()
                .build();

        Edge.buildEdge().setSrc(q1).setDst(q2).setSignals(Set.of('b')).build();
    }

    public State getEntryState() {
        return entryState;
    }
}
