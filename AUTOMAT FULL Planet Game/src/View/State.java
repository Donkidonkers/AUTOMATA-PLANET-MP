package View;

import java.lang.StringBuilder;

public class State {
	public boolean onEarth;
	public int nHumans;
	public int nCow;
	public int nGrain;
	public int nLion;
	public int depth;
	public State previousState;
	
	public int nHumanOnOtherPlanet;
	public int nCowOnOtherPlanet;
	public int nGrainOnOtherPlanet;
	public int nLionOnOtherPlanet;
	
	public State(boolean onEarth, int nHumans, int nCow, int nGrain, int nLion, int depth) {
		this(onEarth, nHumans, nCow, nGrain, nLion, depth, null);
	}
	
	public State(boolean onEarth, int nHumans, int nCow, int nGrain, int nLion, int depth, State previousState) {
		this.onEarth = onEarth;
		this.nHumans = nHumans;
		this.nCow = nCow;
		this.nGrain = nGrain;
		this.nLion = nLion;
		this.depth = depth;
		this.previousState = previousState;
		
		this.nHumanOnOtherPlanet = 2 - nHumans;
		this.nCowOnOtherPlanet = 1 - nCow;
		this.nGrainOnOtherPlanet = 1 - nGrain;
		this.nLionOnOtherPlanet = 1 - nLion;
	}
	
	public boolean checkIfInvalid() {
		boolean loss = false;
		
		if ((nCow == 1 && nHumans >= 1) || //check if the current state is invalid
			(nCow == 1 && nGrain == 1) ||
			(nLion == 1 && nHumans >= 1) ||
			(nCow == 1 && nLion == 1))
			loss = true; 
		
		return loss;
	}
	
	public boolean checkIfInvalidNewState() {
		boolean loss = false;
		if ((previousState.nCow - nCow == 1 && previousState.nHumans - nHumans >= 1) ||  //check if the current state makes the previous state invalid
		(previousState.nCow - nCow == 1 && previousState.nGrain - nGrain == 1) ||
		(previousState.nLion - nLion == 1 && previousState.nHumans - nHumans >= 1) ||
		(previousState.nCow - nCow == 1 && previousState.nLion - nLion == 1))
			loss = true;
		return loss;
	}
	public int getDepth(){
		return this.depth;
	}
	
	@Override
	public boolean equals(Object o) {
		State s = (State) o;
		if (this.nHumans == s.nHumans &&
		   this.nCow == s.nCow 		&&
		   this.nGrain == s.nGrain 	&&
		   this.nLion == s.nLion		&&
		   this.onEarth == s.onEarth)
			return true;
			
		else
			return false;
	}
	
	public String print() { //This will show what you have to do to get to the next state.
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		String onPlanet = onEarth ? "EARTH" : "MARS";
		String onOtherPlanet = onEarth ? "MARS" : "EARTH";
		sb2.append(onOtherPlanet + " " + nHumanOnOtherPlanet + "H " + nCowOnOtherPlanet + "C " + nGrainOnOtherPlanet + "G " + nLionOnOtherPlanet + "L ");
		sb.append(onPlanet + " " + nHumans + "H " + nCow + "C " + nGrain + "G " + nLion + "L " + " " + sb2.toString());
		return sb.toString();
	}
	
}