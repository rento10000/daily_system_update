package controllers.reports;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Report;
import models.validators.ReportValidator;
import utils.DBUtil;

@WebServlet("/repors/message")
public class ReportsMessage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportsMessage() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = (String) request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));

            r.setTitle(request.getParameter("title"));
            r.setContent(request.getParameter("content"));

            String message = request.getParameter("message");
            r.setMessage(request.getParameter("message"));
            if (message == null || message.equals("")) {
                r.setMessage(" ");
            }

            List<String> errors = ReportValidator.validate(r);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("report", r);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/show.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("report_id");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/message.jsp");
                rd.forward(request, response);

                response.sendRedirect(request.getContextPath() + "/reports/index");
            }
        }
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