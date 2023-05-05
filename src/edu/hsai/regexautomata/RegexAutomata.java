package edu.hsai.regexautomata;

import edu.hsai.regexautomata.edge.Edge;
import edu.hsai.regexautomata.exceptions.NotDeterminedAutomata;
import edu.hsai.regexautomata.state.State;

public class RegexAutomata {
    private State currentState = State.nil;
    private String word = "";

    // TODO: use my newly obtained love for builders
    public RegexAutomata(State startingState, String word) {
        currentState = startingState;
        this.word = word + '\0'; // Dealt with string's end in old way purposefully
    }

    // TODO: change to private
    public State nextState(char letter) throws NotDeterminedAutomata {
        int validEdgesCount = 0;
        State nextState = State.nil;

        for (Edge edge : currentState.edges) {
            if (edge.getLetter() == letter) {
                validEdgesCount++;
                nextState = edge.getDst();
            }
        }

        if (validEdgesCount > 1) {
            throw new NotDeterminedAutomata(currentState);
        }

        return nextState;
    }

    // TODO: add analyze (?) method and don't forget about final state
}
