/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebill;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import style.FHeaderTable;
import style.FTable;

/**
 *
 * @author Fikri-Falndi
 */
public class FunctionGetSetData {

    int column;
    DBConnection connect = new DBConnection();
    ResultSet rs = null;
    public void getDataBarang(JTable table) {
        
        int rowCount = 0;
        String query = "SELECT * FROM _barang;";
        try {
            rs = connect.statement().executeQuery(query);
            while (rs.next()) {
                rowCount++;
            }
        } catch (Exception e) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }

        String val[][] = new String[rowCount][6];
        int i = 0;
        try {
            rs = connect.statement().executeQuery(query);
            while (rs.next()) {
                val[i][0] = String.valueOf(i + 1);
                val[i][1] = rs.getString("kode_barang");
                val[i][2] = rs.getString("nama_barang");
                val[i][3] = rs.getString("satuan");
                val[i][4] = rs.getString("harga_satuan");
                val[i][5] = rs.getString("keterangan");
                
                i++;
            }
        } catch (Exception e) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, e);
        }

        String headerTitle[] = {"No", "Kode Barang", "Nama Barang", "Satuan", "Harga Satuan", "Ket"};
        DefaultTableModel tableModel = new DefaultTableModel(val, headerTitle) {
        };
        table.setModel(tableModel);
        
        setTableStyle(table);
    }

    public void setTableStyle(JTable table){
        
        DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
        int tableRow = table.getRowCount();
        if (tableRow < 18) {
            Object ob[] = {"", "", "", "", "", ""};
            for (int k = 0; k < 18 - tableRow; k++) {
                tableModel.addRow(ob);
            }
        }
        
        column = table.getColumnCount();
        for (int j = 0; j < column; j++) {
            table.getColumnModel().getColumn(j).setCellRenderer(new FTable());
            table.getColumnModel().getColumn(j).setHeaderRenderer(new FHeaderTable());
        }
        
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
        }
    }
    
    public void insertData(String query){
        try {
            connect.statement().executeUpdate(query);
           
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getKodeBarang(JComboBox combo, String query){
        try {
            rs = connect.statement().executeQuery(query);
            while(rs.next()){
                combo.addItem(rs.getString("kode_barang"));
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void setData(JTextField text1, JTextField text2, String query){
        try {
            rs = connect.statement().executeQuery(query);
            while(rs.next()){
                text1.setText(rs.getString("nama_barang"));
                text2.setText(rs.getString("satuan"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static String lastKode(String query){
        DBConnection connects = new DBConnection();
        ResultSet rsLast;
        int lastK = 0;
        try {
            rsLast = connects.statement().executeQuery(query);
            while (rsLast.next()) {
                lastK = Integer.parseInt(rsLast.getString("kode_barang").substring(3, 8));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        String lastKd = null;
        switch(String.valueOf(lastK).length()){
            case 1 : lastKd = "KPG0000" + (lastK+1);break;
            case 2 : lastKd = "KPG000" + (lastK+1);break;
            case 3 : lastKd = "KPG00" + (lastK+1);break;
            case 4 : lastKd = "KPG0" + (lastK+1);break;
            default : lastKd = "KPG" + (lastK+1);break;
        }
        
        return lastKd;
    }
    
}
