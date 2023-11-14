package Principal;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Calcular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double consumo = Double.parseDouble(request.getParameter("consumo"));
        ModelEnergia obj_energia = new ModelEnergia(consumo);
        obj_energia.CalcularFornecimento(obj_energia.getConsumo());
        obj_energia.CalcularICMS(obj_energia.getConsumo(), obj_energia.getFornecimento());
        obj_energia.CalcularCofins(obj_energia.getConsumo(), obj_energia.getFornecimento());
        obj_energia.CalcularPisPasep(obj_energia.getConsumo(), obj_energia.getFornecimento());
        obj_energia.CalcularIcmsCofins(obj_energia.getConsumo(), obj_energia.getFornecimento());
        obj_energia.CalcularIcmsPisPasep(obj_energia.getConsumo(), obj_energia.getFornecimento());
        obj_energia.CalcularFatura(obj_energia.getFornecimento(), obj_energia.getIcms(), obj_energia.getCofins(), obj_energia.getPispasep(), obj_energia.getIcmscofins(), obj_energia.getIcmspispasep());
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calculo Energia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>O valor do Fornecimento é: ........................... " + obj_energia.getFornecimento() + "</h2>");
            out.println("<h2>O valor do ICMS é: ................................... " + obj_energia.getIcms() + "</h2>");
            out.println("<h2>O valor do Cofins é: ................................. " + obj_energia.getCofins() + "</h2>");
            out.println("<h2>O valor do PisPasep é: ............................... " + obj_energia.getPispasep() + "</h2>");
            out.println("<h2>O valor do ICMS Cofins é: ............................ " + obj_energia.getIcmscofins()+ "</h2>");
            out.println("<h2>O valor do ICMS Pis Pasep é: ......................... " + obj_energia.getIcmspispasep()+ "</h2>");
            out.println("<h2>O valor da Fatura é: ................................. " + obj_energia.getFatura()+ "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
