package edu.mills.cs114.lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A "solver" that tries to find a sequence of transitions from a given
 * {@link State} to an accept state in a {@link NFA nondeterministic finite
 * automaton (NFA)}.
 * 
 * @author Ellen Spertus
 */
public class Solver {
	private static int numCreatedSolvers = 0;
	private static int numLiveSolvers = 0;
	private final int solverNum;
	private final State currentState;
	private final String string;
	private List<State> path;

	/**
	 * Constructs a {@code Solver} for a given NFA and string, writing information 
	 * about it to {@link System#out}.
	 * 
	 * @param nfa the nondeterministic finite automaton
	 * @param string the string to use as input
	 */
	public Solver(NFA nfa, String string) {
		currentState = nfa.getStartState();
		path = new ArrayList<State>();
		this.string = string;
		solverNum = numCreatedSolvers++;
		numLiveSolvers++;
		System.out.println("Created " + this);
	}    

	/**
     * Constructs a {@code Solver} for a given NFA, string, and path already
     * traversed, writing information about it to {@link System#out}.
	 * 
	 * @param state the current state
	 * @param string the remaining characters in the input
	 * @param path the states already traversed, in order
	 */
	public Solver(State state, String string, List<State> path) {
		this.currentState = state;
		this.string = string;
		// Clone the old path to make sure that modifications to our
		// path don't affect the path parameter, which is passed by reference.
		this.path = new ArrayList<State>(path);
		solverNum = numCreatedSolvers++;
		numLiveSolvers++;
		System.out.println("Created " + this);
	}

	/**
	 * Attempts to find a sequence of states accepting the specified input.
	 * If successful, it outputs the solution to {@link System#out}.
	 */
	public void solve() {
		path.add(currentState);

		// If the string is empty, check if we're in an accept state.
		if (string.length() == 0) {
			if (currentState.isAcceptState()) {
				// If we are in an accept state, print the path we took
				System.out.println("Solution found by solver #" + solverNum + ": " + path);
			} 
		} else {
			// If the string is not empty, transition to another state based on its
			// first character.
		    char firstCharacter = string.charAt(0);
			Set<State> destinations = currentState.getDestinations(firstCharacter);
			// Create a new Solver for every transition on this character.
			for (State nextState : destinations) {
				// Create a new Solver in the next state with the remainder of the string.
				Solver newSolver = new Solver(nextState, string.substring(1), path);
				newSolver.solve();
			}
		}
		numLiveSolvers--;
	}

	/**
	 * Gets the number of live {@code Solver} instances.  This count is incremented
	 * whenever a {@code Solver} is constructed and decremented just before it terminates.
	 * 
	 * @return the number of live {@code Solver} instances.
	 */
	public static int getNumLiveSolvers() {
		return numLiveSolvers;
	}
	
	@Override
    public String toString()
	{
	    return "[Solver #" + solverNum +
	            ": current state: " + currentState +
	            ", path traversed: " + path +
	            ", remaining string: " + string + "]";
	}
}
