
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Hero;
import vista.ChangeVista;
import vista.FirstVista;
import vista.RegisterVista;


public class Control implements ActionListener{
    Hero heros;
    FirstVista firstVist;
    RegisterVista registerVista;
    Connection connection;
    ChangeVista changeVista;

    public Control(Hero heros, FirstVista firstVist, RegisterVista registerVista, ChangeVista changeVista) {
        this.heros = heros;
        this.firstVist = firstVist;
        this.registerVista = registerVista;
        this.changeVista = changeVista;
        assignment();
    }
    

    

        //asignar evento a botones
    public void assignment(){
        firstVist.getBtnAdd().addActionListener(this);
        firstVist.getBtnExit().addActionListener(this);
        firstVist.getBtnSeeTable().addActionListener(this);
        registerVista.getBtnBack().addActionListener(this);
        registerVista.getBtnDelete().addActionListener(this);
        registerVista.getBtnExit().addActionListener(this);
        
    }
    
    
    
        // conexion con base de datos
    
    
    public Connection unite(){
        try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/listadeheroes", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ups...Algo a salido mal, conexion a la base de datos fallida");
        }
        return connection;
        
    }
    
    
        // agregar registro a la base de datos
    
    
    public void addNewHero(){
   
        try {
            Statement stmt = unite().createStatement();
            stmt.executeUpdate("INSERT INTO heroes VALUES ('0000','"+firstVist.getNameTxt().getText() + "', '"+firstVist.getLastNameTxt().getText()+"', '"+ firstVist.getAgeTxt().getText()+"', '"+ firstVist.getAliasTxt().getText()+"' , '"+ firstVist.getGroupTxt().getText()+"' , '"+ firstVist.getStateCoB().getSelectedItem().toString()+"')");
            JOptionPane.showMessageDialog(null, "Hero registrado");
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ups...Algo a salido mal, conexion a la base de datos fallida");
        }

    }
        
        //limpiar campos
    
    public void clean(){
        firstVist.getNameTxt().setText(" ");
        firstVist.getLastNameTxt().setText(" ");
        firstVist.getAgeTxt().setText(" ");
        firstVist.getAliasTxt().setText(" ");
        firstVist.getGroupTxt().setText(" ");
    }
        //Visualisar datos en tabla
        
        
  
    public void seeHerosData(){
        DefaultTableModel md = (DefaultTableModel)registerVista.getTabHeros().getModel();
        try {
            Statement stmt = unite().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM heroes");
            
            rs.first();
            
            do {    
                
                String [] tabRow = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)};
                md.addRow(tabRow);
                
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ups...Algo a salido mal, conexion a la base de datos fallida");
        }
    
    }
    
    //modificar datos
    
    public void changeData(){
        int rowSel = registerVista.getTabHeros().getSelectedRow();
        
        if (rowSel==-1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
        }
            String name = (String) registerVista.getTabHeros().getValueAt(rowSel, 1);
            String lastname = (String) registerVista.getTabHeros().getValueAt(rowSel, 2);
            String age = (String) registerVista.getTabHeros().getValueAt(rowSel, 3);
            String alias = (String) registerVista.getTabHeros().getValueAt(rowSel, 4);
            String group = (String) registerVista.getTabHeros().getValueAt(rowSel, 5);
            String state = (String) registerVista.getTabHeros().getValueAt(rowSel, 6);
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (firstVist.getBtnAdd()==e.getSource()) {
            addNewHero();
            clean();
        }else if (firstVist.getBtnExit()==e.getSource()) {
            firstVist.dispose();
            registerVista.dispose();
        }else if (firstVist.getBtnSeeTable()==e.getSource()) {
            seeHerosData();
            registerVista.setVisible(true);
            firstVist.setVisible(false);
        }else if (registerVista.getBtnExit()==e.getSource()) {
            registerVista.dispose();
            firstVist.dispose();
        }else if (registerVista.getBtnBack()==e.getSource()) {
            firstVist.setVisible(true);
            registerVista.setVisible(false);
        }else if (registerVista.getBtnDelete()==e.getSource()) {
            
        }
    }
    
    
    
}
