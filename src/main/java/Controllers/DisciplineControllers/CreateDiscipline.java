package Controllers.DisciplineControllers;

import Database.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateDiscipline",urlPatterns = "/createDiscipline")
public class CreateDiscipline extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String newDiscipline = req.getParameter("newDisc");
        DBManager.addDiscipline(newDiscipline);
        resp.sendRedirect("/disciplines");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("current_page","/WEB-INF/jsp/disciplineCreating.jsp");
        req.getRequestDispatcher("./WEB-INF/jsp/template.jsp").forward(req,resp);
    }

}
