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
        
        double salarioBruto = Double.parseDouble(request.getParameter("salarioBruto"));
        ModelSalario obj_salario = new ModelSalario(salarioBruto);
        obj_salario.CalcularFGTS(obj_salario.getSalarioBruto());
        obj_salario.CalcularINSS(obj_salario.getSalarioBruto());
        obj_salario.CalcularImpostoRenda(obj_salario.getSalarioBruto());
        obj_salario.CalcularSalarioLiquido(obj_salario.getSalarioBruto(), obj_salario.getInss(), obj_salario.getImpostoRenda());
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Calcular Salário</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>O valor do FGTS é: ................................... R$" + obj_salario.getFgts() + "</h2>");
            out.println("<h2>O valor do INSS é: ................................... R$" + obj_salario.getInss() + "</h2>");
            out.println("<h2>O valor do Imposto de Renda é: ....................... R$" + obj_salario.getImpostoRenda()+ "</h2>");
            out.println("<h2>O valor do Salário Liquido é: ....................... R$" + obj_salario.getSalarioLiquido()+ "</h2>");
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
