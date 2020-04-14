package controllers.reports;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

@WebServlet("/repors/message")
public class ReportsMessage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportsMessage() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        request.setAttribute("_token", request.getSession().getId());

        em.close();

        String message = request.getParameter("message");
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/message.jsp");
        rd.forward(request, response);
    }

}