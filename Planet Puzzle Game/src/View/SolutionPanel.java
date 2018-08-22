
package View;

import java.util.ArrayList;
import java.util.Collections;

public class SolutionPanel extends javax.swing.JPanel {
    public ArrayList<State> solutions = new ArrayList();
    ArrayList<State> moves = new ArrayList();
    public State startState;
    public State endState;
    public breadthFirstSearch bfs;

    public SolutionPanel() {
        initComponents();
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

        for (int i = 0; i < solutions.size(); i++) {
            State s = solutions.get(i);
            while (s.previousState != null) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
