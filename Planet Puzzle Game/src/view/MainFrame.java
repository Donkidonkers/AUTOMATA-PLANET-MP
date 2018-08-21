
package view;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    public static void main(String args[]) { 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startPanel1 = new view.StartPanel();
        solutionPanel1 = new view.SolutionPanel();
        jPanel1 = new javax.swing.JPanel();
        gamePanel1 = new view.GamePanel();
        diagramPanel1 = new view.DiagramPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(735, 625));
        setMinimumSize(new java.awt.Dimension(735, 625));
        setResizable(false);
        setSize(new java.awt.Dimension(735, 625));
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(startPanel1, "card2");

        javax.swing.GroupLayout solutionPanel1Layout = new javax.swing.GroupLayout(solutionPanel1);
        solutionPanel1.setLayout(solutionPanel1Layout);
        solutionPanel1Layout.setHorizontalGroup(
            solutionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        solutionPanel1Layout.setVerticalGroup(
            solutionPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );

        getContentPane().add(solutionPanel1, "card4");

        javax.swing.GroupLayout gamePanel1Layout = new javax.swing.GroupLayout(gamePanel1);
        gamePanel1.setLayout(gamePanel1Layout);
        gamePanel1Layout.setHorizontalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
        );
        gamePanel1Layout.setVerticalGroup(
            gamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout diagramPanel1Layout = new javax.swing.GroupLayout(diagramPanel1);
        diagramPanel1.setLayout(diagramPanel1Layout);
        diagramPanel1Layout.setHorizontalGroup(
            diagramPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        diagramPanel1Layout.setVerticalGroup(
            diagramPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
            .addComponent(diagramPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(gamePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(diagramPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        getContentPane().add(jPanel1, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.DiagramPanel diagramPanel1;
    private view.GamePanel gamePanel1;
    private javax.swing.JPanel jPanel1;
    private view.SolutionPanel solutionPanel1;
    private view.StartPanel startPanel1;
    // End of variables declaration//GEN-END:variables
}
