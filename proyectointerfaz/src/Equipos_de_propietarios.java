import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Equipos_de_propietarios extends JFrame{
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet r;
    DefaultListModel mod = new DefaultListModel();
    private JPanel Panel;
    private JTextField IDt;
    private JTextField velast;
    private JTextField radiost;
    private JTextField estufast;
    private JTextField indicadorest;
    private JTextField brujulast;
    private JTextField anclast;
    private JTextField cuerdast;
    private JTextField lanchast;
    private JTextField salvavidast;
    private JTextField refrigeradorest;
    private JButton agregarbt;
    private JButton consultarbt;
    private JList lista;
    private JButton quitarbt;
    private JTextField idt;
    private JLabel e;


    public Equipos_de_propietarios() {
        consultarbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        agregarbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        quitarbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    eliminar();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void eliminar() throws SQLException {
        conectar();
        ps = con.prepareStatement("DELETE FROM equipo_propietarios WHERE equipo_propid=?" );
        ps.setInt(1, Integer.parseInt(idt.getText()));
        System.out.println("Entró");
        if(ps.executeUpdate() > 0) {
            System.out.println("Eliminado");
        }
        else
            System.out.println("no eliminado");


    }
    public void listar() throws SQLException {
        conectar();
        lista.setModel(mod);
        st = con.createStatement();
        r = st.executeQuery("SELECT equipo_propid, velas, anclas, cuerdas, lanchas, salvavidas, refrigeradores, brujulas, indicadores, estufas, radios FROM equipo_propietarios");
        mod.removeAllElements();
        while(r.next()){
            mod.addElement(" id:"+r.getString(1)+"|"+" velas:"+r.getString(2)+"|"+" anclas:"+r.getString(3)+"|"+" cuerdas:"+r.getString(4)+"|"+" Lanchas:"+r.getString(5)+"|"+" Salvavidas:"+r.getString(6)+"|"+" Refrigeradores:"+r.getString(7)+"|"+" Brujulas:"+r.getString(8)+"|"+" Indicadores:"+r.getString(9)+"|"+" Estufas:"+r.getString(10)+"|"+" Radios:"+r.getString(11));
        }
    }
    public void  insertar() throws SQLException {
        conectar();
        ps = con.prepareStatement("INSERT INTO equipo_propietarios(velas, anclas,cuerdas,lanchas,salvavidas,refrigeradores,brujulas,indicadores,estufas,radios) VALUES (?,?,?,?,?,?,?,?,?,?)");
        //ps.setInt(1, Integer.parseInt(IDt.getText()));
        ps.setInt(1, Integer.parseInt(velast.getText()));
        ps.setInt(2, Integer.parseInt(anclast.getText()));
        ps.setInt(3, Integer.parseInt(cuerdast.getText()));
        ps.setInt(4, Integer.parseInt(lanchast.getText()));
        ps.setInt(5, Integer.parseInt(salvavidast.getText()));
        ps.setInt(6, Integer.parseInt(refrigeradorest.getText()));
        ps.setInt(7, Integer.parseInt(brujulast.getText()));
        ps.setInt(8, Integer.parseInt(indicadorest.getText()));
        ps.setInt(9, Integer.parseInt(estufast.getText()));
        ps.setInt(10, Integer.parseInt(radiost.getText()));
        if(ps.executeUpdate()>0){
            lista.setModel((mod));
            mod.removeAllElements();
            mod.addElement("Insercion exitosa");

            IDt.setText("");
            velast.setText("");
            anclast.setText("");
            cuerdast.setText("");
            lanchast.setText("");
            salvavidast.setText("");
            refrigeradorest.setText("");
            brujulast.setText("");
            indicadorest.setText("");
            estufast.setText("");
            radiost.setText("");
        }
    }
    public static void main(String[] args){
        Equipos_de_propietarios f=new Equipos_de_propietarios();
        f.setContentPane(new Equipos_de_propietarios().Panel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
    }

    public void conectar(){
        try{
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyectoBD","postgres","malcon123");
            System.out.println("conectado");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        }
    }

