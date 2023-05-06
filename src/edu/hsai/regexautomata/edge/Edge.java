package edu.hsai.regexautomata.edge;

import edu.hsai.regexautomata.state.State;

import java.util.Set;

public class Edge {
    private State src;
    private State dst;
    private Set<Character> signals;

    private Edge() {
    }

    public static Builder buildEdge() {
        return new Edge().new Builder();
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

        public Builder setSignals(Set<Character> signals) {
            Edge.this.signals = signals;
            return this;
        }

        public Edge build() {
            return Edge.this;
        }
    }

    public State getDst() {
        return dst;
    }

    public Set<Character> getSignals() {
        return signals;
    }

    @Override
    public String toString() {
        return String.format("src: %s; dst: %s; signals: %s", src, dst, signals.toString());
    }
}
