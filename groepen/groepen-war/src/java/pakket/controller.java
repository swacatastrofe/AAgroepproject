/*
 * testing
 */
package pakket;

import bonen.docentenboonRemote;
import java.io.*;
import java.util.List;
import java.util.logging.*;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Wouter
 */
public class controller extends HttpServlet {
    @EJB private docentenboonRemote dboon;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        if(request.isUserInRole("student"))
        {
            switch(request.getParameter("oorsprong")){
            case("making friends"): makeFriend(request,response);
            case("making enemies"): makeEnemy(request,response);
            }
        }
        else
        {
            String dstatus = request.getParameter("dtoestand");
            if (dstatus==null)
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("naarOverzicht"))
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("voegGroepToe"))
            {
                dboon.voegGroepToe();
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("pasGroepAan"))
            {
                String groepsnr = request.getParameter("groepsnr");
                List studentenInGroep = dboon.getStudentenInGroep(groepsnr);
                List studentenZonderGroep = dboon.getStudentenZonderGroep();
                request.setAttribute("studentenInGroep",studentenInGroep);
                request.setAttribute("studentenZonderGroep",studentenZonderGroep);
                request.setAttribute("groepsnr",groepsnr);
                forward("aanpassengroep.jsp",request,response);
            }
            if(dstatus.equals("voegStudentToe"))
            {
                String groepsnr = request.getParameter("groepsnr");
                String student = request.getParameter("toevoegen");
                dboon.voegStudentToeAanGroep(groepsnr, student);
                List studentenInGroep = dboon.getStudentenInGroep(groepsnr);
                List studentenZonderGroep = dboon.getStudentenZonderGroep();
                request.setAttribute("studentenInGroep",studentenInGroep);
                request.setAttribute("studentenZonderGroep",studentenZonderGroep);
                request.setAttribute("groepsnr",groepsnr);
                forward("aanpassengroep.jsp",request,response);
                
            }
            else
            {
                forward("index.html",request,response);
            }
        }
        
    }
    
    private void forward(String name, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher(name);
           view.forward(request,response);
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

    private void makeFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessie = request.getSession();
        sessie.setAttribute("reden", request.getParameter("vriend"));
        forward("selector.jsp",request,response);
    }

    private void makeEnemy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessie = request.getSession();
        sessie.setAttribute("reden", request.getParameter("vijand"));
        forward("selector.jsp",request,response);
    }

}
