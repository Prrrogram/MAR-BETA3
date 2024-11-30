/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inicial;

import java.awt.HeadlessException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import javax.swing.JPasswordField;
import javax.swing.JTable;

public class CQuejas {
    int codigo;
    String nombreAlumnos;
    String apellidosAlumnos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumnos() {
        return nombreAlumnos;
    }

    public void setNombreAlumnos(String nombreAlumnos) {
        this.nombreAlumnos = nombreAlumnos;
    }
    
    
    public void RegistroQuejas(JTextField paramNombres){
        
        
        setNombreAlumnos(paramNombres.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta =("INSERT INTO Soporte (Quejas) values (?);");
        
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, getNombreAlumnos());
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "Se guardo la queja.");

            
            
            
        }catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "No se inserto correctamente el alumno, error: "+ ex.toString());
            
            FormCrear objetoCrear = new FormCrear();
            objetoCrear.setVisible(true);
        }

    }
    
    
}
