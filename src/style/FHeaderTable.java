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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Fikri-Falndi
 */
public class FHeaderTable implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(final JTable table, final Object value, final boolean isSelected, final boolean hasFocus, final int row, final int column) {
        //final Color warna = (Color)value;
        final JLabel label = new JLabel();
        label.setOpaque(true);
       
        if(isSelected){
            label.setBackground(table.getSelectionBackground());
            label.setForeground(Color.WHITE);
        }else{
            label.setBackground(new Color(2, 93, 135));
            label.setForeground(Color.WHITE);
        }
        label.setBorder(new EmptyBorder(2, 2, 2, 2));
        label.setFont(new Font("Humanst521 BT", Font.ITALIC, 16));
        label.setHorizontalAlignment(SwingConstants.CENTER);
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
