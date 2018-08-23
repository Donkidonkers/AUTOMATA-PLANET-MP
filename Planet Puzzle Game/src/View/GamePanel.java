
package View;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class GamePanel extends javax.swing.JPanel {
    public ArrayList<Thing> earth = new ArrayList<Thing>();
    public ArrayList<Thing> mars = new ArrayList<Thing>();
    public ArrayList<Thing> spaceship = new ArrayList<Thing>();
    public boolean onEarth = true; //initially on earth
    Thing scientist = new Thing("Scientist");
    Thing cow = new Thing("Cow");
    Thing grain = new Thing("Grain");
    Thing human1 = new Thing("Human");
    Thing human2 = new Thing("Human");
    Thing lion = new Thing("Lion");
    
    private int movesInt = 0;

    public GamePanel() {
        initComponents();
        initializeGame();
    }

    public void initializeGame() {
        earth.add(scientist);
        earth.add(cow);
        earth.add(grain);
        earth.add(human1);
        earth.add(human2);
        earth.add(lion);
    }

    public boolean checkForLoss() {
        boolean loss = false;
        if (!earth.contains(scientist)) {
            if ((earth.contains(cow) && earth.contains(grain))
                    || (earth.contains(human1) && earth.contains(cow))
                    || (earth.contains(human1) && earth.contains(lion))
                    || (earth.contains(human2) && earth.contains(cow))
                    || (earth.contains(human2) && earth.contains(lion))
                    || (earth.contains(lion) && earth.contains(cow))) {
                loss = true;
            } else if (!mars.contains(scientist)) {
                if ((mars.contains(cow) && mars.contains(grain))
                        || (mars.contains(human1) && mars.contains(cow))
                        || (mars.contains(human1) && mars.contains(lion))
                        || (mars.contains(human2) && mars.contains(cow))
                        || (mars.contains(human2) && mars.contains(lion))
                        || (mars.contains(lion) && mars.contains(cow))) {
                    loss = true;
                }
            }
        }

        return loss;
    }

    public boolean checkForWin() {
        if (earth.size() == 0) {
            return true;
        }
        return false;
    }

    public void restartGame() {
        for (int i = 0; i < spaceship.size(); i++){
            spaceship.remove(i);
        }
        for (int i = 0; i < mars.size(); i++){
            mars.remove(i);
        }
        for (int i = 0; i < earth.size(); i++){
            earth.remove(i);
        }
        initializeGame();
        onEarth=true;
        movesInt = 0;
        scientistPng.setBounds(30, 260, 75, 120);
        grainPng.setBounds(140, 290, 70, 80);
        cowPng.setBounds(120, 180, 120, 91);
        lionPng.setBounds(110, 80, 120, 103);
        human1Png.setBounds(20, 150, 90, 136);
        human2Png.setBounds(10, 60, 90, 136);
        rocketPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/rocket.png")));
        numberMovesLbl.setText(Integer.toString(movesInt));
        currentStateLbl.setText("q" + Integer.toString(checkState()));
    }
    
    public boolean onShip(Thing name){
        for (int i = 0; i < spaceship.size(); i++){
            if (spaceship.get(i) == name) {
                return true;
            }
        }
        return false;
    }
    
    public boolean toShip(Thing name){ 
        if(onEarth){
            for (int i = 0; i < mars.size(); i++){
                if (mars.get(i) == name)
                    return false;
            }
        }
        
        else {
            for (int i = 0; i < earth.size(); i++){
                if (earth.get(i) == name)
                    return false;
            }
        }
        return true;
    }

    public int checkState() {
        //earth.contains()
        if (earth.contains(scientist) && earth.contains(grain) && earth.contains(cow) &&
            earth.contains(lion) && earth.contains(human1) && earth.contains(human2))
            return 0;
        if (mars.contains(scientist) && earth.contains(grain) && mars.contains(cow) &&
            mars.contains(lion) && earth.contains(human1) && earth.contains(human2))
            return 1;
        if (earth.contains(scientist) && earth.contains(grain) && mars.contains(cow) &&
            earth.contains(lion) && earth.contains(human1) && earth.contains(human2))
            return 2;
        if (mars.contains(scientist) && earth.contains(grain) && mars.contains(cow) &&
            earth.contains(lion) && mars.contains(human1) && mars.contains(human2))
            return 3;
        if (earth.contains(scientist) && earth.contains(grain) && earth.contains(cow) &&
            earth.contains(lion) && mars.contains(human1) && mars.contains(human2))
            return 4;
        if (mars.contains(scientist) && mars.contains(grain) && earth.contains(cow) &&
            mars.contains(lion) && mars.contains(human1) && mars.contains(human2))
            return 5;
        if (earth.contains(scientist) && mars.contains(grain) && earth.contains(cow) &&
            earth.contains(lion) && mars.contains(human1) && mars.contains(human2))
            return 6;
        if (mars.contains(scientist) && mars.contains(grain) && mars.contains(cow) &&
            mars.contains(lion) && mars.contains(human1) && mars.contains(human2))
            return 7;
        if (earth.contains(scientist) && earth.contains(grain) && earth.contains(cow) &&
            mars.contains(lion) && earth.contains(human1) && earth.contains(human2))
            return 8;
        if (mars.contains(scientist) && mars.contains(grain) && mars.contains(cow) &&
            mars.contains(lion) && earth.contains(human1) && earth.contains(human2))
            return 9;
        else
            return 00;
    }

    /*
    SCIENTIST EARTH BOUNDS: scientistPng.setBounds(30, 260, 75, 120);
    GRAIN EARTH BOUNDS: grainPng.setBounds(140, 290, 70, 80);
    COW EARTH BOUNDS: cowPng.setBounds(120, 180, 120, 91);
    LION EARTH BOUNDS: lionPng.setBounds(110, 80, 120, 103);
    HUMAN1 EARTH BOUNDS: human1Png.setBounds(20, 150, 90, 136);
    HUMAN2 EARTH BOUNDS: human2Png.setBounds(10, 60, 90, 136);
    
    SCIENTIST MARS BOUNDS: scientistPng.setBounds(630, 230, 75, 120);
    GRAIN MARS BOUNDS: grainPng.setBounds(550, 270, 70, 80);
    COW MARS BOUNDS: cowPng.setBounds(520, 170, 120, 91);
    LION MARS BOUNDS: lionPng.setBounds(510, 70, 120, 103);
    HUMAN1 MARS BOUNDS: human1Png.setBounds(620, 120, 90, 136); 
    HUMAN2 MARS BOUNDS: human2Png.setBounds(610, 30, 90, 136);
    
    SCIENTIST ROCKET BOUNDS: scientistPng.setBounds(440, 150, 75, 120);
    GRAIN ROCKET BOUNDS: grainPng.setBounds(390, 250, 70, 80);
    COW ROCKET BOUNDS: cowPng.setBounds(290, 230, 120, 91);
    LION ROCKET BOUNDS: lionPng.setBounds(350, 200, 120, 103);
    HUMAN1 ROCKET BOUNDS: human1Png.setBounds(350, 130, 90, 136);
    HUMAN2 ROCKET BOUNDS: human2Png.setBounds(270, 140, 90, 136);
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gamePanel = new javax.swing.JPanel();
        nullPanel = new javax.swing.JPanel();
        numberMovesLbl = new javax.swing.JLabel();
        movesLbl = new javax.swing.JLabel();
        sendBtn = new javax.swing.JButton();
        scientistPng = new javax.swing.JLabel();
        grainPng = new javax.swing.JLabel();
        cowPng = new javax.swing.JLabel();
        lionPng = new javax.swing.JLabel();
        human1Png = new javax.swing.JLabel();
        human2Png = new javax.swing.JLabel();
        rocketPng = new javax.swing.JLabel();
        backgroundImg = new javax.swing.JLabel();
        diagramPanel = new javax.swing.JPanel();
        nullPanel2 = new javax.swing.JPanel();
        restartBtn = new javax.swing.JButton();
        currentStateLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        backgroundNFA = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(713, 579));

        gamePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        nullPanel.setLayout(null);

        numberMovesLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        numberMovesLbl.setForeground(new java.awt.Color(255, 255, 255));
        numberMovesLbl.setText("0");
        nullPanel.add(numberMovesLbl);
        numberMovesLbl.setBounds(80, 10, 110, 18);

        movesLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        movesLbl.setForeground(new java.awt.Color(255, 255, 255));
        movesLbl.setText("MOVES: ");
        nullPanel.add(movesLbl);
        movesLbl.setBounds(10, 10, 70, 18);

        sendBtn.setBackground(new java.awt.Color(255, 255, 255));
        sendBtn.setForeground(new java.awt.Color(255, 51, 51));
        sendBtn.setText("SEND");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });
        nullPanel.add(sendBtn);
        sendBtn.setBounds(609, 355, 80, 30);

        scientistPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/scientist.png"))); // NOI18N
        scientistPng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scientistPngMouseClicked(evt);
            }
        });
        nullPanel.add(scientistPng);
        scientistPng.setBounds(30, 260, 75, 120);

        grainPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/grain.png"))); // NOI18N
        grainPng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grainPngMouseClicked(evt);
            }
        });
        nullPanel.add(grainPng);
        grainPng.setBounds(130, 290, 70, 80);

        cowPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/cow.png"))); // NOI18N
        cowPng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cowPngMouseClicked(evt);
            }
        });
        nullPanel.add(cowPng);
        cowPng.setBounds(110, 190, 120, 91);

        lionPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/lion.png"))); // NOI18N
        lionPng.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lionPngMouseClicked(evt);
            }
        });
        nullPanel.add(lionPng);
        lionPng.setBounds(120, 100, 120, 103);

        human1Png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/human2.png"))); // NOI18N
        human1Png.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                human1PngMouseClicked(evt);
            }
        });
        nullPanel.add(human1Png);
        human1Png.setBounds(20, 150, 90, 136);

        human2Png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/human1.png"))); // NOI18N
        human2Png.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                human2PngMouseClicked(evt);
            }
        });
        nullPanel.add(human2Png);
        human2Png.setBounds(20, 60, 100, 136);

        rocketPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/rocket.png"))); // NOI18N
        rocketPng.setText("ROCKET");
        nullPanel.add(rocketPng);
        rocketPng.setBounds(240, 220, 290, 140);

        backgroundImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BackgroundSpace.png"))); // NOI18N
        nullPanel.add(backgroundImg);
        backgroundImg.setBounds(0, 0, 711, 410);

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nullPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );

        diagramPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));

        nullPanel2.setLayout(null);

        restartBtn.setBackground(new java.awt.Color(255, 255, 255));
        restartBtn.setForeground(new java.awt.Color(255, 51, 51));
        restartBtn.setText("RESTART");
        restartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartBtnActionPerformed(evt);
            }
        });
        nullPanel2.add(restartBtn);
        restartBtn.setBounds(310, 110, 90, 30);

        currentStateLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        currentStateLbl.setForeground(new java.awt.Color(255, 255, 255));
        currentStateLbl.setText("q0");
        nullPanel2.add(currentStateLbl);
        currentStateLbl.setBounds(620, 90, 80, 50);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("1: Going to Mars");
        nullPanel2.add(jLabel4);
        jLabel4.setBounds(10, 150, 91, 15);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("0: Going to Earth");
        nullPanel2.add(jLabel3);
        jLabel3.setBounds(10, 130, 110, 15);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("STATE");
        nullPanel2.add(jLabel2);
        jLabel2.setBounds(620, 60, 52, 21);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("YOU ARE IN");
        nullPanel2.add(jLabel1);
        jLabel1.setBounds(600, 30, 110, 21);

        backgroundNFA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/BackgroundNFA.png"))); // NOI18N
        backgroundNFA.setToolTipText("");
        nullPanel2.add(backgroundNFA);
        backgroundNFA.setBounds(0, 0, 713, 170);

        javax.swing.GroupLayout diagramPanelLayout = new javax.swing.GroupLayout(diagramPanel);
        diagramPanel.setLayout(diagramPanelLayout);
        diagramPanelLayout.setHorizontalGroup(
            diagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nullPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        diagramPanelLayout.setVerticalGroup(
            diagramPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nullPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(diagramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diagramPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void scientistPngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scientistPngMouseClicked
        if (toShip(scientist)) {
            if (onShip(scientist)) {
                if (onEarth) {
                    earth.add(scientist);
                    spaceship.remove(scientist);
                    scientistPng.setBounds(30, 260, 75, 120);
                } else {
                    mars.add(scientist);
                    spaceship.remove(scientist);
                    scientistPng.setBounds(630, 230, 75, 120);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(scientist);
                        spaceship.add(scientist);
                    } else {
                        mars.remove(scientist);
                        spaceship.add(scientist);
                    }
                    scientistPng.setBounds(440, 150, 75, 120);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_scientistPngMouseClicked

    private void grainPngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grainPngMouseClicked
        if (toShip(grain)) {
            if (onShip(grain)) {
                if (onEarth) {
                    earth.add(grain);
                    spaceship.remove(grain);
                    grainPng.setBounds(140, 290, 70, 80);
                } else {
                    mars.add(grain);
                    spaceship.remove(grain);
                    grainPng.setBounds(140, 290, 70, 80);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(grain);
                        spaceship.add(grain);
                    } else {
                        mars.remove(grain);
                        spaceship.add(grain);
                    }
                    grainPng.setBounds(390, 250, 70, 80);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_grainPngMouseClicked

    private void cowPngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cowPngMouseClicked
        if (toShip(cow)) {
            if (onShip(cow)) {
                if (onEarth) {
                    earth.add(cow);
                    spaceship.remove(cow);
                    cowPng.setBounds(120, 180, 120, 91);
                } else {
                    mars.add(cow);
                    spaceship.remove(cow);
                    cowPng.setBounds(520, 170, 120, 91);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(cow);
                        spaceship.add(cow);
                    } else {
                        mars.remove(cow);
                        spaceship.add(cow);
                    }
                    cowPng.setBounds(290, 230, 120, 91);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_cowPngMouseClicked

    private void lionPngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lionPngMouseClicked
        if (toShip(lion)) {
            if (onShip(lion)) {
                if (onEarth) {
                    earth.add(lion);
                    spaceship.remove(lion);
                    lionPng.setBounds(110, 80, 120, 103);
                } else {
                    mars.add(lion);
                    spaceship.remove(lion);
                    lionPng.setBounds(510, 70, 120, 103);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(lion);
                        spaceship.add(lion);
                    } else {
                        mars.remove(lion);
                        spaceship.add(lion);
                    }
                    lionPng.setBounds(350, 200, 120, 103);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_lionPngMouseClicked

    private void human1PngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_human1PngMouseClicked
        if (toShip(human1)) {
            if (onShip(human1)) {
                if (onEarth) {
                    earth.add(human1);
                    spaceship.remove(human1);
                    human1Png.setBounds(20, 150, 90, 136);
                } else {
                    mars.add(human1);
                    spaceship.remove(human1);
                    human1Png.setBounds(620, 120, 90, 136);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(human1);
                        spaceship.add(human1);
                    } else {
                        mars.remove(human1);
                        spaceship.add(human1);
                    }
                    human1Png.setBounds(350, 130, 90, 136);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_human1PngMouseClicked

    private void human2PngMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_human2PngMouseClicked
        if (toShip(human2)) {
            if (onShip(human2)) {
                if (onEarth) {
                    earth.add(human2);
                    spaceship.remove(human2);
                    human2Png.setBounds(10, 60, 90, 136);
                } else {
                    mars.add(human2);
                    spaceship.remove(human2);
                    human2Png.setBounds(610, 30, 90, 136);
                }

            } else {
                if (spaceship.size() <= 2) {
                    if (onEarth) {
                        earth.remove(human2);
                        spaceship.add(human2);
                    } else {
                        mars.remove(human2);
                        spaceship.add(human2);
                    }
                    human2Png.setBounds(270, 140, 90, 136);
                } else {
                    JOptionPane.showMessageDialog(null, "The Rocketship can only contain upto the SCIENTIST and 2 other ITEMS");
                }
            }
        }
    }//GEN-LAST:event_human2PngMouseClicked

    private void restartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartBtnActionPerformed
        restartGame();
    }//GEN-LAST:event_restartBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        if (spaceship.contains(scientist)) {
            if (onEarth) {
                for (int i = 0; i < spaceship.size(); i++) {
                    mars.add(spaceship.get(i));
                    if (spaceship.get(i) == scientist) {
                        scientistPng.setBounds(630, 230, 75, 120);
                    }
                    if (spaceship.get(i) == grain) {
                        grainPng.setBounds(550, 270, 70, 80);
                    }
                    if (spaceship.get(i) == cow) {
                        cowPng.setBounds(520, 170, 120, 91);
                    }
                    if (spaceship.get(i) == lion) {
                        lionPng.setBounds(510, 70, 120, 103);
                    }
                    if (spaceship.get(i) == human1) {
                        human1Png.setBounds(620, 120, 90, 136);
                    }
                    if (spaceship.get(i) == human2) {
                        human2Png.setBounds(610, 30, 90, 136);
                    }
                }
                spaceship.clear();
                onEarth = false;
                rocketPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/rocketflip.png")));
            } else {
                for (int i = 0; i < spaceship.size(); i++) {
                    earth.add(spaceship.get(i));
                    if (spaceship.get(i) == scientist) {
                        scientistPng.setBounds(30, 260, 75, 120);
                    }
                    if (spaceship.get(i) == grain) {
                        grainPng.setBounds(140, 290, 70, 80);
                    }
                    if (spaceship.get(i) == cow) {
                        cowPng.setBounds(120, 180, 120, 91);
                    }
                    if (spaceship.get(i) == lion) {
                        lionPng.setBounds(110, 80, 120, 103);
                    }
                    if (spaceship.get(i) == human1) {
                        human1Png.setBounds(20, 150, 90, 136);
                    }
                    if (spaceship.get(i) == human2) {
                        human2Png.setBounds(10, 60, 90, 136);
                    }
                }
                spaceship.clear();
                onEarth = true;
                rocketPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/rocket.png")));
            }
            movesInt++;
            numberMovesLbl.setText(Integer.toString(movesInt));
            currentStateLbl.setText("q" + Integer.toString(checkState()));
            if (checkForLoss()) {
                System.out.println("You failed to save humanity.");
                JOptionPane.showMessageDialog(null, "You failed to save humanity! Moves done: "+ movesInt);
                restartGame();
            }
            if (checkForWin()) {
                System.out.println("Congratulations you saved humanity! Moves done: " + movesInt);
                JOptionPane.showMessageDialog(null, "Congratulations you saved humanity! Moves done: " + movesInt);
                restartGame();
            }
        } 
        else {
            System.out.println("The Scientist is the only one who can fly the rocketship");
            JOptionPane.showMessageDialog(null, "The SCIENTIST is the only one who can fly the rocketship");
        }    
    }//GEN-LAST:event_sendBtnActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JLabel backgroundNFA;
    private javax.swing.JLabel cowPng;
    private javax.swing.JLabel currentStateLbl;
    private javax.swing.JPanel diagramPanel;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel grainPng;
    private javax.swing.JLabel human1Png;
    private javax.swing.JLabel human2Png;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lionPng;
    private javax.swing.JLabel movesLbl;
    private javax.swing.JPanel nullPanel;
    private javax.swing.JPanel nullPanel2;
    private javax.swing.JLabel numberMovesLbl;
    private javax.swing.JButton restartBtn;
    private javax.swing.JLabel rocketPng;
    private javax.swing.JLabel scientistPng;
    private javax.swing.JButton sendBtn;
    // End of variables declaration//GEN-END:variables
}
