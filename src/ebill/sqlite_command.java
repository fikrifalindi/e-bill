/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Fikri-Falndi
 */
public class sqlite_command {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:ebill.db");
            con.setAutoCommit(false);
            System.out.println("Opened database successfully");
            
            stm = con.createStatement();
//            String query = "CREATE TABLE _stok" +
//                            "(id            int(8)      PRIMARY KEY NOT NULL," +
//                            "kode_barang    char(8)     NOT NULL," +
//                            "tgl            DATE        NOT NULL," +
//                            "stok           INT(4)      NOT NULL," +
//                            "masuk          INT(4)      NOT NULL," +
//                            "keluar         INT(4)      NOT NULL," +
//                            "ket            TEXT        NOT NULL)";
            
//            String query = "CREATE TABLE _barang" +
//                            "(kode_barang   CHAR(8)     PRIMARY KEY NOT NULL," +
//                            "nama_barang    TEXT        NOT NULL," +
//                            "satuan         CHAR(5)     NOT NULL," +
//                            "harga_satuan   INT(7)      NOT NULL," +
//                            "keterangan     TEXT        NOT NULL)";
//            
//            String query = "DROP TABLE _barang";
//            String query = "UPDATE _stok set tgl='20/10/2016'";
//            String query = "INSERT INTO _stok VALUES('1', 'KPG00001','','50','10','3','-')";
//            stm.executeUpdate(query);
//            ResultSet rs = stm.executeQuery("SELECT * FROM _stok;");
//            while(rs.next()){
//                String id = rs.getString("id");
//                String kode_barang = rs.getString("kode_barang");
//                String tgl = rs.getString("tgl");
//                String stok = rs.getString("stok");
//                String masuk = rs.getString("masuk");
//                String keluar = rs.getString("keluar");
//                String keterangan = rs.getString("ket");
//                System.out.println("Kode Barang = " + id);
//                System.out.println("Nama Barang = " + kode_barang);
//                System.out.println("Tanggal     = " + tgl);
//                System.out.println("Stock       = " + stok);
//                System.out.println("Masuk       = " + masuk);
//                System.out.println("Keluar      = " + keluar);
//                System.out.println("Keterangan  = " + keterangan);
//            }
            stm.close();
            con.commit();
            con.close();
//            System.out.println("Table created successfully");
//            System.out.println("Records inputted successfully");
            System.out.println("Operation done successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        
    }
    
}
