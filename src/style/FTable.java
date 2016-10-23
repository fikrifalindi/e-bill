/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package style;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Fikri-Falndi
 */
public class FTable implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        //final Color warna = (Color)value;
        final JLabel label = new JLabel();
        label.setOpaque(true);
       
        if(isSelected){
            label.setBackground(table.getSelectionBackground());
            label.setForeground(Color.WHITE);
        }else{
            if(row%2==0){
                label.setBackground(new Color(238, 239, 236));
            }else{
                label.setBackground(new Color(183, 190, 230));
            }
            label.setForeground(new Color(70, 70, 70));
        }
        label.setBorder(new EmptyBorder(10, 10, 10, 10));
        label.setFont(new Font("Humanst521 BT", 0, 16));
        String val;
        if(value == null){
            val = String.valueOf("");
        }else{
            val = String.valueOf(value);
        }
        label.setText(val);
        
        return label;
    }
    
}
