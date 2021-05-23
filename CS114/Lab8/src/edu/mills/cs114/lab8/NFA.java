package edu.mills.cs114.lab8;

import java.io.IOException;
import java.util.Scanner;

/**
 * A nondeterministic finite automaton.  It is guaranteed to have a start state
 * and may have any number of accept states, including zero.
 * 
 * @author Ellen Spertus
 */
public class NFA {
	private final State startState;

	/**
	 * Constructs a nondeterministic finite automaton with the specified start state.
	 * 
	 * @param startState the start state
	 */
	public NFA(State startState) {
		this.startState = startState;
	}

	private static NFA buildNFA1() {
		// Create states.
		State startState = new State(false);
		State state1 = new State(true);  	// state1 is an accept state
		State state2 = new State(false);
		
		// Add transitions.
		startState.addEdge('a', state1);
		startState.addEdge('a', state2);
		state1.addEdge('a', state1);
		state1.addEdge('b', state2);
		state2.addEdge('a', state2);
		state2.addEdge('b', state1);

		// Create NFA.
		NFA nfa = new NFA(startState);	
		return nfa;
	}

	/**
	 * Gets the start state.
	 * 
	 * @return the start state
	 */
	public State getStartState() {
		return startState;
	}
	
	/**
	 * Tests whether a {@code String} from {@link System#in} is accepted by a specific NFA.
	 * 
	 * @param args ignored
	 * @throws IOException if unable to read from {@link System#in}
	 */
	public static void main(String args[]) throws IOException {
		// Create an NFA.
		NFA NFA1 = buildNFA1();

		// Read in a String to use as input to the NFA.
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string: ");
		String string = scanner.nextLine();
		scanner.close();

		// Determine whether the NFA accepts the String.
		Solver solver = new Solver(NFA1, string);
		solver.solve();

/*		while (Solver.getNumSolvers() > 0) {
		    synchronized(??) {
			??.wait();
		    }
		}*/
	}
}
