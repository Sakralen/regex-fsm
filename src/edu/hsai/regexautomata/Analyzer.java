package edu.hsai.regexautomata;

import edu.hsai.regexautomata.edge.Edge;
import edu.hsai.regexautomata.state.State;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Analyzer {
    private State currentState;
    private final ArrayList<Character> chars;

    public Analyzer(State startingState, String word) {
        currentState = startingState;
        this.chars = word.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayList::new));
    }

    private State next(Character letter) {
        for (Edge edge : currentState.edges) {
            if (edge.getSignals().contains(letter)) {
                return edge.getDst();
            }
        }

        return State.nil;
    }

    public boolean isRegexed() {
        for (Character letter : chars) {
            currentState = next(letter);
            if (currentState == State.nil) {
                return false;
            }
        }

        return currentState.isFinal();
    }
}
