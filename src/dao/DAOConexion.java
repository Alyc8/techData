package dao;
import java.sql.*;

/**
 *
 * @author #RoaAlyc '^'
 */
public class DAOConexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/bd_techdata";
    String usuario="root";
    String password="aza8888"; 
    
    public void Conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion exitosa \n");
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }         
    }
    
    public void Desconectar() throws SQLException{
        if (con.isClosed()==false) {
            con.close();
        }
    }   
}