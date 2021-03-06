/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import Minimax.Minimax;
import Minimax.Tablero;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author AlexAlmora
 */
public class Conecta4 extends javax.swing.JFrame {

    private Minimax juego;
    private Tablero tablero;
    private int[][] matrix;
    private final static ImageIcon[] IMAGENES = {
        new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Images/rojo.png")),
        new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Images/fondo.png")),
        new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Images/azul.png"))};

    /**
     * Creates new form NewJFrame
     */
    public Conecta4() {
        int[][] matrix2 = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        matrix = matrix2;
        initComponents();
        for(int i=0;i<7;i++){
            jTable1.getColumnModel().getColumn(i).setWidth(80);
        }
        this.bEnabled(false);
       /* jTable1.getColumnModel().getColumn(0).setHeaderRenderer(new ButtonsRenderer(bUno));
        jTable1.getColumnModel().getColumn(1).setHeaderRenderer(new ButtonsRenderer(bDos));
        jTable1.getColumnModel().getColumn(2).setHeaderRenderer(new ButtonsRenderer(bTres));
        jTable1.getColumnModel().getColumn(3).setHeaderRenderer(new ButtonsRenderer(bCuatro));
        jTable1.getColumnModel().getColumn(4).setHeaderRenderer(new ButtonsRenderer(bCinco));
        jTable1.getColumnModel().getColumn(5).setHeaderRenderer(new ButtonsRenderer(bSeis));
        jTable1.getColumnModel().getColumn(6).setHeaderRenderer(new ButtonsRenderer(bSiete));
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bUno = new javax.swing.JButton();
        bDos = new javax.swing.JButton();
        bTres = new javax.swing.JButton();
        bCuatro = new javax.swing.JButton();
        bCinco = new javax.swing.JButton();
        bSeis = new javax.swing.JButton();
        bSiete = new javax.swing.JButton();
        bInicio = new javax.swing.JButton();
        bReinicio = new javax.swing.JButton();
        cMaquinaInicia = new javax.swing.JComboBox();
        cNivel = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(375, 460));
        jScrollPane1.setViewportView(jTable1);
        jScrollPane1.setWheelScrollingEnabled(false);

        jTable1.setBackground(new java.awt.Color(173, 133, 26));
        jTable1.setModel(new ImageTableModel(
            new Object [][] {
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]},
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]},
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]},
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]},
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]},
                {IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1],IMAGENES[1]}
            },
            new Object[]{
                1,2,3,4,5,6,7
            }
        ));
        jTable1.setRowHeight(75);
        jTable1.setRowMargin(0);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.setSize(new java.awt.Dimension(371, 450));
        jScrollPane1.setViewportView(jTable1);

        bUno.setText("1");
        bUno.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bUno.setMaximumSize(new java.awt.Dimension(100, 75));
        bUno.setMinimumSize(new java.awt.Dimension(100, 75));
        bUno.setPreferredSize(new java.awt.Dimension(100, 75));
        bUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUnoActionPerformed(evt);
            }
        });

        bDos.setText("2");
        bDos.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bDos.setMaximumSize(new java.awt.Dimension(100, 75));
        bDos.setMinimumSize(new java.awt.Dimension(100, 75));
        bDos.setPreferredSize(new java.awt.Dimension(100, 75));
        bDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDosActionPerformed(evt);
            }
        });

        bTres.setText("3");
        bTres.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bTres.setMaximumSize(new java.awt.Dimension(100, 75));
        bTres.setMinimumSize(new java.awt.Dimension(100, 75));
        bTres.setPreferredSize(new java.awt.Dimension(100, 75));
        bTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTresActionPerformed(evt);
            }
        });

        bCuatro.setText("4");
        bCuatro.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bCuatro.setMaximumSize(new java.awt.Dimension(100, 75));
        bCuatro.setMinimumSize(new java.awt.Dimension(100, 75));
        bCuatro.setPreferredSize(new java.awt.Dimension(100, 75));
        bCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCuatroActionPerformed(evt);
            }
        });

        bCinco.setText("5");
        bCinco.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bCinco.setMaximumSize(new java.awt.Dimension(100, 75));
        bCinco.setMinimumSize(new java.awt.Dimension(100, 75));
        bCinco.setPreferredSize(new java.awt.Dimension(100, 75));
        bCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCincoActionPerformed(evt);
            }
        });

        bSeis.setText("6");
        bSeis.setBounds(new java.awt.Rectangle(0, 0, 175, 175));
        bSeis.setMaximumSize(new java.awt.Dimension(100, 75));
        bSeis.setMinimumSize(new java.awt.Dimension(100, 75));
        bSeis.setPreferredSize(new java.awt.Dimension(100, 75));
        bSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeisActionPerformed(evt);
            }
        });

        bSiete.setText("7");
        bSiete.setBounds(new java.awt.Rectangle(0, 0, 75, 75));
        bSiete.setMaximumSize(new java.awt.Dimension(150, 75));
        bSiete.setMinimumSize(new java.awt.Dimension(150, 75));
        bSiete.setPreferredSize(new java.awt.Dimension(100, 75));
        bSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSieteActionPerformed(evt);
            }
        });

        bInicio.setText("Iniciar Juego");
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });

        bReinicio.setText("Reiniciar Juego");
        bReinicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReinicioActionPerformed(evt);
            }
        });

        cMaquinaInicia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inicia Maquina", "Inicia Jugador" }));

        cNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel Facil (3-niveles)", "Nivel Medio (5-niveles)", "Nivel Dificil (7-niveles)" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bInicio)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cMaquinaInicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bReinicio)
                            .addComponent(bSiete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(bInicio))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cMaquinaInicia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bReinicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bTres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCuatro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCinco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSeis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSiete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed

        tablero = new Tablero(matrix, 0);
        int nivel = (cNivel.getSelectedIndex() + 1);
        if(nivel == 1){
            nivel = 3;
        }else if(nivel == 2){
            nivel = 5;
        }else{
            nivel =7;
        }
        juego = new Minimax(tablero, nivel, (cMaquinaInicia.getSelectedIndex() == 0));
        if (cMaquinaInicia.getSelectedIndex() == 0) {
            printTable(juego.playGame(), 1);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Inicia el Usuario");
        }
        bEnabled(true);
        this.bInicio.setVisible(false);
    }//GEN-LAST:event_bInicioActionPerformed

    private void bUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUnoActionPerformed
     pulsaBoton(Integer.parseInt(bUno.getText())-1);
    }//GEN-LAST:event_bUnoActionPerformed

    private void bDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDosActionPerformed
        pulsaBoton(Integer.parseInt(bDos.getText())-1);
    }//GEN-LAST:event_bDosActionPerformed

    private void bTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTresActionPerformed
pulsaBoton(Integer.parseInt(bTres.getText())-1); 
    }//GEN-LAST:event_bTresActionPerformed

    private void bCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCuatroActionPerformed
      pulsaBoton(Integer.parseInt(bCuatro.getText())-1);
    }//GEN-LAST:event_bCuatroActionPerformed

    private void bCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCincoActionPerformed
pulsaBoton(Integer.parseInt(bCinco.getText())-1);
    }//GEN-LAST:event_bCincoActionPerformed

    private void bSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeisActionPerformed
pulsaBoton(Integer.parseInt(bSeis.getText())-1);
    }//GEN-LAST:event_bSeisActionPerformed

    private void bSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSieteActionPerformed
pulsaBoton(Integer.parseInt(bSiete.getText())-1);
    }//GEN-LAST:event_bSieteActionPerformed

    private void bReinicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReinicioActionPerformed
        this.setVisible(false);
        dispose();
        new Conecta4().setVisible(true);
    }//GEN-LAST:event_bReinicioActionPerformed
    private void printTable(int col, int tipo) {        
        for (int i = 5; i >= 0; i--) {
            if (matrix[i][col] == 0) {
                matrix[i][col]=tipo;
                jTable1.setValueAt(IMAGENES[tipo + 1], i, col);
                return;
            }
        }
        
    }

    private void printTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                jTable1.setValueAt(IMAGENES[matrix[i][j] + 1], i, j);
            }
        }
    }

    private boolean isGameEnd() {
        if (juego.isDraw()) {
            JOptionPane.showMessageDialog(rootPane, "Empate");
            bEnabled(false);
            printTable();
            return true;
        } else if (juego.isWinner() == 1) {
            JOptionPane.showMessageDialog(rootPane, "Ha ganado la maquina");
            bEnabled(false);
            printTable();
            return true;
        } else if (juego.isWinner() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Ha ganado el Jugador");
            bEnabled(false);
            printTable();
            return true;
        } else {
            return false;
        }
    }

    private void bEnabled(boolean flag) {
        bUno.setEnabled(flag);
        bDos.setEnabled(flag);
        bTres.setEnabled(flag);
        bCuatro.setEnabled(flag);
        bCinco.setEnabled(flag);
        bSeis.setEnabled(flag);
        bSiete.setEnabled(flag);
    }
    private void pulsaBoton(int n){
        System.out.println("==========Inicia Jugador==============");
        if (juego.playerMove(n)) {
            printTable(n, -1);
            if (!this.isGameEnd()) {
                System.out.println("============Inicia Maquina============");
                printTable(juego.playGame(), 1);
            }
            if (this.isGameEnd()) {
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Esa posicion ya esta llena, intenta otra");
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Conecta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conecta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conecta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conecta4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conecta4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCinco;
    private javax.swing.JButton bCuatro;
    private javax.swing.JButton bDos;
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bReinicio;
    private javax.swing.JButton bSeis;
    private javax.swing.JButton bSiete;
    private javax.swing.JButton bTres;
    private javax.swing.JButton bUno;
    private javax.swing.JComboBox cMaquinaInicia;
    private javax.swing.JComboBox cNivel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
