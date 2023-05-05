package edu.hsai.regexautomata.edge;

import edu.hsai.regexautomata.state.State;

public class Edge {
    private State src;
    private State dst;
    private char letter;

    private Edge() {
    }

    public class Builder {
        private Builder() {
        }
        public Builder setSrc(State src) {
            Edge.this.src = src;
            src.addEdge(Edge.this);
            return this;
        }

        public Builder setDst(State dst) {
            Edge.this.dst = dst;
            return this;
        }

        public Builder setLetter(char letter) {
            Edge.this.letter = letter;
            return this;
        }

        public Edge build() {
            return Edge.this;
        }
    }

    public State getDst() {
        return dst;
    }

    public char getLetter() {
        return letter;
    }

    public static Builder buildEdge() {
        return new Edge().new Builder();
    }

    @Override
    public String toString() {
        return String.format("src: %s; dst: %s; letter: %s", src, dst, letter);
    }
}
