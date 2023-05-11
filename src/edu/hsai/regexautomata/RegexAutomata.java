package edu.hsai.regexautomata;

import edu.hsai.regexautomata.finiteautomata.Edge;
import edu.hsai.regexautomata.finiteautomata.State;

import java.util.HashSet;
import java.util.Set;

public class RegexAutomata {
    private final State entryState;
    private static final Set<Character> alphabet = new HashSet<>();

    public RegexAutomata() {
        initAlphabet();

        State q34 = State.buildState().makeFinal().build();

        State q27 = State.buildState().connectTo(q34, '"').build();
        State q26 = State.buildState().connectTo(q27, 'g').build();
        State q25 = State.buildState()
                .connectTo(q26, 'e')
                .connectTo(q27, 'g').build();
        State q24 = State.buildState().connectTo(q25, 'p').build();

        State q30 = State.buildState().connectTo(q34, '"').build();
        State q29 = State.buildState().connectTo(q30, 'p').build();
        State q28 = State.buildState().connectTo(q29, 'm').build();

        State q33 = State.buildState().connectTo(q34, '"').build();
        State q32 = State.buildState().connectTo(q33, 'g').build();
        State q31 = State.buildState().connectTo(q32, 'n').build();

        State q23 = State.buildState()
                .connectTo(q24, 'j')
                .connectTo(q28, 'b')
                .connectTo(q31, 'p').build();

        State q22 = State.buildState().connectTo(q23, '.').connectToItself(alphabet).build();
        State q21 = State.buildState().connectTo(q22, alphabet).build();
        Edge.buildEdge().setSrc(q22).setDst(q21).setSignals('/').build();

        State q20 = State.buildState().connectTo(q21, '/').build();

        State q19 = State.buildState().connectToItself(alphabet).build();

        var exceptM = new HashSet<>(alphabet);
        exceptM.remove('m');
        State q18 = State.buildState().connectTo(q20, 'm').connectTo(q19, exceptM).build();

        var exceptO = new HashSet<>(alphabet);
        exceptO.remove('o');
        State q17 = State.buildState().connectTo(q18, 'o').connectTo(q19, exceptO).build();

        var exceptHyphenAndC = new HashSet<>(alphabet);
        exceptHyphenAndC.remove('-');
        exceptHyphenAndC.remove('c');
        State q16 = State.buildState().connectTo(q17, 'c').connectTo(q19, exceptHyphenAndC).build();

        Edge.buildEdge().setSrc(q19).setDst(q16).setSignals('.').build();
        Edge.buildEdge().setSrc(q18).setDst(q16).setSignals('.').build();
        Edge.buildEdge().setSrc(q17).setDst(q16).setSignals('.').build();

        State q15 = State.buildState().connectTo(q16, '.').connectToItself(alphabet).build();

        var exceptHyphen = new HashSet<>(alphabet);
        exceptHyphen.remove('-');

        State q14 = State.buildState().connectTo(q15, exceptHyphen).build();
        State q13 = State.buildState().connectTo(q14, '.').build();
        State q12 = State.buildState().connectTo(q13, 'w').build();
        State q11 = State.buildState().connectTo(q12, 'w').build();
        State q10 = State.buildState().connectTo(q11, 'w').connectTo(q15, exceptHyphen).build();

        State q9 = State.buildState().connectTo(q10, '/').build();
        State q8 = State.buildState().connectTo(q9, '/').build();
        State q7 = State.buildState().connectTo(q8, ':').build();
        State q6 = State.buildState().connectTo(q7, 's').connectTo(q8, ':').build();

        State q5 = State.buildState().connectTo(q6, 'p').build();
        State q4 = State.buildState().connectTo(q5, 't').build();
        State q3 = State.buildState().connectTo(q4, 't').build();
        State q2 = State.buildState().connectTo(q3, 'h').build();
        State q1 = State.buildState().connectTo(q2, '"').build();

        entryState = q1;
    }

    public void initAlphabet() {
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }

        for (char c = '0'; c <= '9'; c++) {
            alphabet.add(c);
        }

        alphabet.add('-');
    }

    public State getEntryState() {
        return entryState;
    }
}
