package controllers.reports;

import java.io.IOException;
import java.sql.Date;
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

@WebServlet("/reports/show")
public class ReportsShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportsShowServlet() {
        super();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = (String) request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Report r = em.find(Report.class, Integer.parseInt(request.getParameter("report_id")));

            r.setReport_date(Date.valueOf(request.getParameter("report_date")));
            r.setTitle(request.getParameter("title"));
            r.setContent(request.getParameter("content"));

            String message  = request.getParameter("message");
            r.setMessage(request.getParameter("message"));
            if(message == null || message.equals("")) {
                r.setMessage(" ");
            }

            List<String> errors = ReportValidator.validate(r);
            if (errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("report", r);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("report_id");

                response.sendRedirect(request.getContextPath() + "/reports/index");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        request.setAttribute("_token", request.getSession().getId());

        Report r = em.find(Report.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("report", r);
        request.setAttribute("_token", request.getSession().getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/show.jsp");
        rd.forward(request, response);
    }

}