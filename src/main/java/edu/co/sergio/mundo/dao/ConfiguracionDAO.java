package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.co.sergio.mundo.dao.Conexion;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguracionDAO {

    private Connection conexion;

    public ConfiguracionDAO() {
        try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(ConfiguracionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public boolean insertar(int id, int Precio, int cantidad) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO habitacion VALUES(?,?,?,'Disponible')";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, id);
            statement.setInt(2, Precio);
            statement.setInt(3, cantidad);
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }

    public ArrayList<Habitacion> listarTodo() {
        //1.Consulta
        ArrayList<Habitacion> respuesta = new ArrayList<Habitacion>();
        String consulta = "SELECT * FROM habitacion";
        try {
            //----------------------------
            //Statement
            Statement statement
                    = this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado
                    = statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while (resultado.next()) {
                Habitacion hab = new Habitacion();
                hab.setId(resultado.getInt("id"));
                hab.setPrecio(resultado.getInt("precio"));
                hab.setPersonas(resultado.getInt("cantidadPersonas"));
                hab.setEstado(resultado.getString("estado"));
                respuesta.add(hab);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

}
