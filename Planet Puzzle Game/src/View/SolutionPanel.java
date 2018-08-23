
package View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            fastestsolutionLbl.append(startState.print()+ "\n");
            //System.out.println(startState.print());
            
            for (State state : moves) {
               fastestsolutionLbl.append(state.print()+ "\n"); 
                //System.out.println(state.print()); //start from the end of the list so that we start at the start state, because we got the moves starting from the end state

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fastestsolutionLbl = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));

        fastestsolutionLbl.setEditable(false);
        fastestsolutionLbl.setBackground(new java.awt.Color(0, 0, 102));
        fastestsolutionLbl.setColumns(20);
        fastestsolutionLbl.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        fastestsolutionLbl.setForeground(new java.awt.Color(255, 255, 255));
        fastestsolutionLbl.setRows(5);
        fastestsolutionLbl.setText("                                   Fastest Solution\n");
        jScrollPane1.setViewportView(fastestsolutionLbl);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setText("Fastest Solution");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea2.setBackground(new java.awt.Color(0, 0, 102));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setText("\t\t\t\t    Text Solution\n\n   1. Move the Scientist, Cow, and Lion to Mars\n   2. Move the Scientist and Lion back to Earth\n   3. Move the Scientist and the Two Humans to Mars\n   4. Move the Scientist and Cow back to Earth\n   5. Move the Scientist, Grain, and Cow to Mars\n   6. Move the Scientist and Cow back to Earth\n   7. Move the Scientist, Cow, and Lion to Mars\n\n      You saved Humanity!...\n");
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(285, 285, 285))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        initializeStates();
        try {
            generateSolutions();
        } catch (InterruptedException ex) {
            Logger.getLogger(SolutionPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        representSolutions();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea fastestsolutionLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
