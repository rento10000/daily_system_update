package controllers.reports;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/report/comment")
public class ReportComment extends HttpServlet {
private static final long serialVersionUID = 1L;
public ReportComment() {
super();
}
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String message = request.getParameter("message");
request.setAttribute("message", message);
RequestDispatcher rd = request.getRequestDispatcher("/employees/show.jsp");
rd.forward(request, response);
}
}