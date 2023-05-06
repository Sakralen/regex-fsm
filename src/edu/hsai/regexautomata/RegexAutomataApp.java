package edu.hsai.regexautomata;

import edu.hsai.regexautomata.finiteautomata.Edge;
import edu.hsai.regexautomata.finiteautomata.State;

import java.util.Set;

public class RegexAutomataApp {
    public static void main(String[] args) {
        RegexAutomata automata = new RegexAutomata();

        String word = "ab";
        System.out.println(Analyzer.analyze(automata, word));
        word = "aaab";
        System.out.println(Analyzer.analyze(automata, word));
        word = "bab";
        System.out.println(Analyzer.analyze(automata, word));
        word = "abb";
        System.out.println(Analyzer.analyze(automata, word));
        word = "b";
        System.out.println(Analyzer.analyze(automata, word));

        System.out.println(Generator.generate(automata));
    }
}
