package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.dao.ConfiguracionDAO;
import edu.co.sergio.mundo.vo.Habitacion;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrearListar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ArrayList<Habitacion> lista = null;
        //1. Crear instancia del DAO        
        ConfiguracionDAO daoE = new ConfiguracionDAO();
        //Lista todos los elementos.
        lista = daoE.listarTodo();
        //2. Envio de los datos por el request.
        request.setAttribute("habitaciones", lista);
        //3. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("Listar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.Captura de datos del formulario
        String id = request.getParameter("id");
        String precio = request.getParameter("precio");
        String cantidad = request.getParameter("cantidad");

        //3. Crear el DTO
        Habitacion hab = new Habitacion();
        hab.setId(Integer.parseInt(id));
        hab.setPrecio(Integer.parseInt(precio));
        hab.setPersonas(Integer.parseInt(cantidad));

        //4. Enlazarme con el DAO.
        ConfiguracionDAO daoHab = new ConfiguracionDAO();
        boolean resultado = daoHab.insertar(hab.getId(), hab.getPrecio(), hab.getPersonas());
        if (resultado == false) {
            request.setAttribute("insersion", "OK");
        } else {
            request.setAttribute("insersion", "NOK");
        }
        //5. RequestDispacher
        RequestDispatcher rd = request.getRequestDispatcher("Configurar.jsp");
        rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
