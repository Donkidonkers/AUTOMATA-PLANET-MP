import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Automat {
	public Scanner sc = new Scanner(System.in);
	public ArrayList<Thing> earth = new ArrayList<Thing>();
	public ArrayList<Thing> mars = new ArrayList<Thing>();
	public ArrayList<Thing> spaceship = new ArrayList<Thing>();
	public boolean running = true;
	public boolean onEarth = true; //initially on earth
	Thing scientist = new Thing("Scientist");
	Thing cow = new Thing("Cow");
	Thing grain = new Thing("Grain");
	Thing human = new Thing("Human");
	Thing human2 = new Thing("Human");
	Thing lion = new Thing("Lion");
	public State startState;
	public ArrayList<State> solutions = new ArrayList();
	public State endState;
	public breadthFirstSearch bfs;
	ArrayList<State> moves = new ArrayList();
	public void initializeGame(){
		
		earth.add(scientist);
		
		earth.add(cow);
		
		earth.add(grain);
		
		earth.add(human);
		
		earth.add(human2);
		
		earth.add(lion);	
	}
	
	public void initializeStates() {
		startState = new State(true, 2, 1, 1, 1, 1);
		endState = new State(false, 2, 1, 1, 1, 1);
		bfs = new breadthFirstSearch(startState, endState);
	}
	
	public void generateSolutions() throws InterruptedException {
		solutions = bfs.generateSolutions();
	}
	
	public void representSolutions() {
		
		for(int i = 0; i < solutions.size(); i++) {
			State s = solutions.get(i);
			while(s.previousState != null) {
				//System.out.println(s.print());
				moves.add(s);
				s = s.previousState; //get all the moves
				
			}
			Collections.reverse(moves);
			System.out.println(startState.print());
			for (State state : moves) {
				System.out.println(state.print()); //start from the end of the list so that we start at the start state, because we got the moves starting from the end state
				
			}
		}
	}
	public void representPlanets() {
		if(onEarth)
			System.out.print("On ");
		System.out.println("Earth");
		if (earth.size() != 0)
			for (int i = 0; i < earth.size(); i++) {
				System.out.print(earth.get(i).getSymbol() + " ");
			}
		System.out.println();
		if(!onEarth)
			System.out.print("On ");
		System.out.println("Mars");
		if (mars.size() != 0)
			for (int i = 0; i < mars.size(); i++) {
				System.out.print(mars.get(i).getSymbol() + " ");
			}
		System.out.println();
	}
	public Automat() throws InterruptedException {
		initializeGame();
		while(running) {
			representPlanets();
			if(onEarth) {
				System.out.println("First thing to bring aboard spaceship? S to solve! ");
				String c = sc.nextLine();
				while(c.equals("L") && c.equals("G") && c.equals("C") && c.equals("H") && c.equals("S")) {
					System.out.println("Invalid input please try again ");
					c = sc.nextLine();
				}
				if(c.equals("L")) {
					System.out.println("Scientist has added the Lion to the spaceship");
					earth.remove(lion);
					spaceship.add(lion);
				} else if (c.equals("G")) {
					System.out.println("Scientist has added the Grain to the spaceship");
					earth.remove(grain);
					spaceship.add(grain);
				} else if (c.equals("C")) {
					System.out.println("Scientist has added the Cow to the spaceship");
					earth.remove(cow);
					spaceship.add(cow);
				} else if (c.equals("H")) {
					System.out.println("Scientist has added a Human to the spaceship");
					if (earth.contains(human)){
						earth.remove(human);
						spaceship.add(human);
					} else {
						earth.remove(human2);
						spaceship.add(human2);
					}
				} else if (c.equals("S")) {
					initializeStates();
					generateSolutions();
					representSolutions();
				}
					
				System.out.println("Second thing to bring aboard spaceship? N for nothing ");
				
				String c1 = sc.nextLine();
				while(c.equals("L") && c.equals("G") && c.equals("C") && c.equals("H") && c.equals("N")) {
					System.out.println("Invalid input please try again ");
					c1 = sc.nextLine();
				}
				if(c1.equals("L")) {
					System.out.println("Scientist has added the Lion to the spaceship");
					earth.remove(lion);
					spaceship.add(lion);
				} else if (c1.equals("G")) {
					System.out.println("Scientist has added the Grain to the spaceship");
					earth.remove(grain);
					spaceship.add(grain);
				} else if (c1.equals("C")) {
					System.out.println("Scientist has added the Cow to the spaceship");
					earth.remove(cow);
					spaceship.add(cow);
				} else if (c1.equals("H")) {
					System.out.println("Scientist has added a Human to the spaceship");
					if (earth.contains(human)){
						earth.remove(human);
						spaceship.add(human);
					} else {
						earth.remove(human2);
						spaceship.add(human2);
					}
				}
				earth.remove(scientist);
				spaceship.add(scientist);
				for(int i = 0; i < spaceship.size(); i++) {
					mars.add(spaceship.get(i));
				}
				spaceship.clear();
				onEarth = false;
			} else {
				System.out.println("First thing to bring aboard spaceship? ");
				String c = sc.nextLine();
				while(c.equals("L") && c.equals("G") && c.equals("C") && c.equals("H")) {
					System.out.println("Invalid input please try again ");
					c = sc.nextLine();
				}
				if(c.equals("L")) {
					System.out.println("Scientist has added the Lion to the spaceship");
					mars.remove(lion);
					spaceship.add(lion);
				} else if (c.equals("G")) {
					System.out.println("Scientist has added the Grain to the spaceship");
					mars.remove(grain);
					spaceship.add(grain);
				} else if (c.equals("C")) {
					System.out.println("Scientist has added the Cow to the spaceship");
					mars.remove(cow);
					spaceship.add(cow);
				} else if (c.equals("H")) {
					System.out.println("Scientist has added a Human to the spaceship");
					if (mars.contains(human)){
						mars.remove(human);
						spaceship.add(human);
					} else {
						mars.remove(human2);
						spaceship.add(human2);
					}
				}
					
				System.out.println("Second thing to bring aboard spaceship? N for nothing ");
				
				String c1 = sc.nextLine();
				while(c.equals("L") && c.equals("G") && c.equals("C") && c.equals("H") && c.equals("N")) {
					System.out.println("Invalid input please try again ");
					c1 = sc.nextLine();
				}
				if(c1.equals("L")) {
					System.out.println("Scientist has added the Lion to the spaceship");
					mars.remove(lion);
					spaceship.add(lion);
				} else if (c1.equals("G")) {
					System.out.println("Scientist has added the Grain to the spaceship");
					mars.remove(grain);
					spaceship.add(grain);
				} else if (c1.equals("C")) {
					System.out.println("Scientist has added the Cow to the spaceship");
					mars.remove(cow);
					spaceship.add(cow);
				} else if (c1.equals("H")) {
					System.out.println("Scientist has added a Human to the spaceship");
					if (mars.contains(human)){
						mars.remove(human);
						spaceship.add(human);
					} else {
						mars.remove(human2);
						spaceship.add(human2);
					}
				}
				mars.remove(scientist);
				spaceship.add(scientist);
				for(int i = 0; i < spaceship.size(); i++) {
					earth.add(spaceship.get(i));
				}
				spaceship.clear();
				onEarth = true;
			}
			if(checkForLoss()) {
				System.out.println("You failed to save humanity.");
				running = false;
			}
			if (checkForWin()) {
				System.out.println("Congratulations you saved humanity!");
				running = false;
			}
		}
	}
	
	public boolean checkForLoss(){
		boolean loss = false;
		if (!earth.contains(scientist))
			if((earth.contains(cow) && earth.contains(grain)) || 
				(earth.contains(human) && earth.contains(cow)) ||
				(earth.contains(human) && earth.contains(lion)) ||
				(earth.contains(human2) && earth.contains(cow)) ||
				(earth.contains(human2) && earth.contains(lion)) ||
				(earth.contains(lion) && earth.contains(cow)))
				loss = true;
		else if (!mars.contains(scientist))
			if((mars.contains(cow) && mars.contains(grain)) || 
				(mars.contains(human) && mars.contains(cow)) ||
				(mars.contains(human) && mars.contains(lion)) ||
				(mars.contains(human2) && mars.contains(cow)) ||
				(mars.contains(human2) && mars.contains(lion)) ||
				(mars.contains(lion) && mars.contains(cow)))
				loss = true;
		
		return loss;
	}
	
	public boolean checkForWin() {
		if (earth.size() == 0) {
			return true;
		}
		return false;
	}
}