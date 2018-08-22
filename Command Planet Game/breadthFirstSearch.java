import java.util.ArrayList;

public class breadthFirstSearch {
	public ArrayList<State> validStates  = new ArrayList(); //we only care about the valid states when we create the solution
	public State startState;
	public State endState;
	public ArrayList<State> traveledStates = new ArrayList();
	
	public breadthFirstSearch(State startState, State endState) {
		this.startState = startState;
		this.endState = endState;
		validStates.add(startState);
	}
	
	public void addValidState(State state) {
		if (!state.checkIfInvalid())
			validStates.add(state);
	}
	
	public ArrayList<State> generateSolutions() throws InterruptedException{
		ArrayList<State> solutions = new ArrayList();
		int shortestSolutionDepth = 0;
		boolean allOptimalSolutionsFound = false;
		boolean foundFirstSolution = false;
		while (0 < validStates.size() && !allOptimalSolutionsFound) {//if we've gone through all the states then there's no solution
			State currentState = validStates.get(0);
			validStates.remove(0);
			if(!traveledStates.contains(currentState)) {
				if(currentState.equals(endState)) {
					if(foundFirstSolution) {//found another solution that's shorter or just as short as the first one
						if(currentState.getDepth() <= shortestSolutionDepth) {
							solutions.add(currentState);
						} else {//we're at a depth deeper than our previously found solution, so there's no point looking for better solutions 
							allOptimalSolutionsFound = true;
						}
					} else { //first found solution
						foundFirstSolution = true;
						shortestSolutionDepth = currentState.getDepth();
						solutions.add(currentState);
					}
				} else {
					getSuccessors(currentState); //not at end state yet, generate new states based on the possible transitions
				}
				traveledStates.add(currentState);
			}
		}
		
		return solutions;
	}
	
	
	private void getSuccessors(State currentState) {
		boolean onEarth = !currentState.onEarth;
		int humans = currentState.nHumans, 
		cow = currentState.nCow, 
		grain = currentState.nGrain, 
		lion = currentState.nLion;
		int humanCtr = humans;
		//GENERATE ALL POSSIBLE STATES GIVEN THE CURRENT CONFIGURATION
		if (humanCtr == 2) {
			State s = new State(onEarth, 2, currentState.nCowOnOtherPlanet, currentState.nGrainOnOtherPlanet, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			humanCtr--;
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(humanCtr == 1 && cow == 1) {
			State s = new State(onEarth, 1, 1, currentState.nGrainOnOtherPlanet, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(humanCtr == 1 && grain == 1) {
			State s = new State(onEarth, 1, currentState.nCowOnOtherPlanet, 1, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(humanCtr == 1 & lion == 1) {
			State s = new State(onEarth, 1, currentState.nCowOnOtherPlanet, currentState.nGrainOnOtherPlanet, 1, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(cow == 1 && lion == 1) {
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, 1, currentState.nGrainOnOtherPlanet, 1, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(cow == 1 && grain == 1) {
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, 1, 1, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(lion == 1 && grain == 1) {
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, currentState.nCowOnOtherPlanet, 1, 1, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}
		if(humanCtr == 1) {
			State s = new State(onEarth, 1, currentState.nCowOnOtherPlanet, currentState.nGrainOnOtherPlanet, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(cow == 1) {
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, 1, currentState.nGrainOnOtherPlanet, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(grain == 1){
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, currentState.nCowOnOtherPlanet, 1, currentState.nLionOnOtherPlanet, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}if(lion == 1) {
			State s = new State(onEarth, currentState.nHumanOnOtherPlanet, currentState.nCowOnOtherPlanet, currentState.nGrainOnOtherPlanet, 1, currentState.getDepth() + 1, currentState);
			if(!s.checkIfInvalidNewState()) {
				validStates.add(s);
			}
		}
	}

}