/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author AlexAlmora
 */
public class ButtonsRenderer implements TableCellRenderer {
    private JComponent boton;
    ButtonsRenderer(JComponent boton){
        this.boton=boton;
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this.boton;
    }
    
    
}
