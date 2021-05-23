package edu.mills.cs114.lab8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * A node in a {@link NFA non-deterministic finite state automaton (NFA)}.
 */
public class State {
    private static int numStates = 0;
    private final boolean isAcceptState;
    private final int number;
    private HashMap<Character, Set<State>> edges;

    /**
     * Constructs a new {@code Node} with no outgoing edges.
     * 
     * @param isAcceptState whether this is an accept state
     */
    public State(boolean isAcceptState) {
        this.isAcceptState = isAcceptState;
        this.number = numStates++;
        edges = new HashMap<Character, Set<State>>();
    }

    /**
     * Adds an edge indicating a transition to another {@code State}.
     * There can be be multiple transitions on the same character.
     * 
     * @param value the character on which the transition should occur
     * @param destination the new {@code State} after the transition
     */
    public void addEdge(char value, State destination) {
        Set<State> destinations = edges.get(value);
        if (destinations == null) {
            destinations = new HashSet<State>();
        }
        destinations.add(destination);
        edges.put(value, destinations);
    }

    /**
     * Returns the {@code State}s that can be reached by transitions from
     * this one on the specified character.  If no states can be reached,
     * the empty set is returned.
     * 
     * @param value the character on which the transition should occur
     * @return the {@code State}s that can be reached by transitions from
     *         this one on the specified character
     */
    public Set<State> getDestinations(char value) {
        if (edges.containsKey(value)) {
            return edges.get(value);
        } else {
            return new HashSet<State>();
        }
    }

    /**
     * Returns whether this is an accept state.
     * 
     * @return whether this is an accept state
     */
    public boolean isAcceptState() {
        return isAcceptState;
    }

    /**
     * Returns this {@code State}'s ordinal number, based on the order in which
     * it was created relative to other {@code State}s.
     * 
     * @return a non-negative integer
     */
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString()
    {
        return "S" + number;
    }
}

