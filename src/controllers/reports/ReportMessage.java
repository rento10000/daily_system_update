package controllers.reports;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/repors/message")
public class ReportMessage extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReportMessage() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/reports/show.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/message.jsp");
        rd.forward(request, response);
    }
}