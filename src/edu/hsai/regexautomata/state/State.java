package edu.hsai.regexautomata.state;

import edu.hsai.regexautomata.edge.Edge;

import java.util.ArrayList;

public class State {
    public final ArrayList<Edge> edges = new ArrayList<>();
    private String id;
    private boolean isFinal = false;
    public static State nil = buildState().setId("nil").build();

    private State() {
    }

    public static Builder buildState() {
        return new State().new Builder();
    }

    public class Builder {
        private Builder() {
        }
        public Builder setId(String id) {
            State.this.id = id;
            return this;
        }

        public Builder makeFinal() {
            State.this.isFinal = true;
            return this;
        }

        public Builder connectTo(State dst, char letter) {
            Edge.buildEdge().setSrc(State.this).setDst(dst).setLetter(letter).build();
            return this;
        }

        public Builder connectToItself(char letter) {
            Edge.buildEdge().setSrc(State.this).setDst(State.this).setLetter(letter).build();
            return this;
        }

        public State build() {
            return State.this;
        }
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return (!isFinal) ? id : (id + " (final)");
    }
}
