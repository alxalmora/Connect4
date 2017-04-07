/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tablero;

import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlexAlmora
 */
public class ImageTableModel extends DefaultTableModel {
    public ImageTableModel(Object[][] rowData, Object[] columnNames){
        super(rowData, columnNames);
        
    }
    
    public Class getColumnClass(int col){
        return Icon.class;
    }
    public boolean isCellEditable(int col, int row){
        return false;
    }
}
