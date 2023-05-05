package edu.hsai.regexautomata.exceptions;

import edu.hsai.regexautomata.state.State;

public class NotDeterminedAutomata extends Exception {
    public NotDeterminedAutomata(State state) {
        super("Automata is not determined! Determine transitions for " + state.getId());
    }
}
