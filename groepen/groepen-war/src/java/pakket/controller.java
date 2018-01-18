package pakket;

import bonen.docentenboonRemote;
import java.io.*;
import java.util.*;
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
                HttpSession sessie = request.getSession();
                
        if(request.isUserInRole("student"))
        {
            String oorsprong = request.getParameter("oorsprong");
            if (oorsprong == null)
            {
                String name = request.getUserPrincipal().getName();
                List vrienden = dboon.getVriendenVanStudent(name);
                request.setAttribute("vrienden", vrienden);
                List vijanden = dboon.getVijandenVanStudent(name);
                request.setAttribute("vijanden",vijanden);
                forward("studentenwelkom.jsp",request,response);
            }
            else {
            switch(oorsprong){
            case("making friends"): makeFriend(request,response);
            case("making enemies"): makeEnemy(request,response);
            case("logout"):
                sessie.invalidate();
                forward("login.jsp",request,response);
/**
            try{
                switch(request.getParameter("oorsprong")){
                    case("making friends"): 
                        makeFriend(request,response);
                        break;
                    case("making enemies"): 
                        makeEnemy(request,response);
                        break;
                    case("logout"):
                        sessie.invalidate();
                        forward("login.jsp",request,response);
                        break;
                }
            }
            catch(NullPointerException e){
                onthaal(request,response);
**/
            }
            }
        }
        else
        {
            String dstatus = request.getParameter("dtoestand");
            if (dstatus==null)
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                List aantalConflicten = dboon.getAantalConlficten();
                request.setAttribute("conflicten",aantalConflicten);
                int aantalTot = dboon.getAantalStudenten();
                request.setAttribute("totaal", aantalTot);
                int aantalZonder = dboon.getAantalStudentenZonderGroep();
                request.setAttribute("zonder", aantalZonder);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("naarOverzicht"))
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                List aantalConflicten = dboon.getAantalConlficten();
                request.setAttribute("conflicten",aantalConflicten);
                int aantalTot = dboon.getAantalStudenten();
                request.setAttribute("totaal", aantalTot);
                int aantalZonder = dboon.getAantalStudentenZonderGroep();
                request.setAttribute("zonder", aantalZonder);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("voegGroepToe"))
            {
                dboon.voegGroepToe();
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                List aantalConflicten = dboon.getAantalConlficten();
                request.setAttribute("conflicten",aantalConflicten);
                int aantalTot = dboon.getAantalStudenten();
                request.setAttribute("totaal", aantalTot);
                int aantalZonder = dboon.getAantalStudentenZonderGroep();
                request.setAttribute("zonder", aantalZonder);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("pasGroepAan"))
            {
                String groepsnr = request.getParameter("groepsnr");
                String fin = dboon.isGroepFinaal(groepsnr);
                if (fin.equals("0"))
                {
                    List studentenInGroep = dboon.getStudentenInGroep(groepsnr);
                    List studentenZonderGroep = dboon.getStudentenZonderGroep();
                    List vriendenZonderGroep = dboon.getVrienden(groepsnr);
                    List vijanden = dboon.getVijanden(groepsnr);
                    request.setAttribute("studentenInGroep",studentenInGroep);
                    request.setAttribute("studentenZonderGroep",studentenZonderGroep);
                    request.setAttribute("vrienden",vriendenZonderGroep);
                    request.setAttribute("vijanden",vijanden);
                    request.setAttribute("groepsnr",groepsnr);
                    forward("aanpassengroep.jsp",request,response);
                }
                else
                {
                    forward("groepfinaal.jsp",request,response);
                }
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
            if(dstatus.equals("verwijderStudent"))
            {
                String groepsnr = request.getParameter("groepsnr");
                String student = request.getParameter("verwijderen");
                dboon.voegStudentToeAanGroep("0", student);
                List studentenInGroep = dboon.getStudentenInGroep(groepsnr);
                List studentenZonderGroep = dboon.getStudentenZonderGroep();
                request.setAttribute("studentenInGroep",studentenInGroep);
                request.setAttribute("studentenZonderGroep",studentenZonderGroep);
                request.setAttribute("groepsnr",groepsnr);
                forward("aanpassengroep.jsp",request,response);
            }
            if(dstatus.equals("finaliseren"))
            {
                String groepsnr = request.getParameter("groepsnr");
                dboon.finaliseerGroep(groepsnr);
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                forward("docentenoverzicht.jsp",request,response);
            }
            if(dstatus.equals("naarDocentenOverzicht"))
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                forward("docentenoverzicht.jsp",request,response);
            }
            if (dstatus.equals("logout"))
            {
                sessie.invalidate();
                forward("login.jsp",request,response);
            }
            else
            {
                List groepen = dboon.getGroepen();
                request.setAttribute("groepen",groepen);
                List aantalConflicten = dboon.getAantalConlficten();
                request.setAttribute("conflicten",aantalConflicten);
                int aantalTot = dboon.getAantalStudenten();
                request.setAttribute("totaal", aantalTot);
                int aantalZonder = dboon.getAantalStudentenZonderGroep();
                request.setAttribute("zonder", aantalZonder);
                forward("docentenoverzicht.jsp",request,response);
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

    private void onthaal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("studentenwelkom.jsp",request,response);
    }

}
