package edu.hsai.regexfsm;

import edu.hsai.regexfsm.finitestatemachine.Edge;
import edu.hsai.regexfsm.finitestatemachine.State;

import java.util.ArrayList;
import java.util.stream.Collectors;

// ArrayList<Characters> is used over String or char[] or etc. due to
// potential ability to make these implemented classes generic.
public class Analyzer {
    private static State currentState;

    public static boolean analyze(RegexFsm automata, String word) {
        currentState = automata.getEntryState();
        ArrayList<Character> chars = word.chars().mapToObj(e -> (char) e).collect(Collectors.toCollection(ArrayList::new));

        for (Character letter : chars) {
            currentState = next(letter);
            if (currentState == State.nil) {
                return false;
            }
        }

        return currentState.isFinal();
    }

    private static State next(Character letter) {
        for (Edge edge : currentState.edges) {
            if (edge.signals.contains(letter)) {
                return edge.getDst();
            }
        }

        return State.nil;
    }
}
