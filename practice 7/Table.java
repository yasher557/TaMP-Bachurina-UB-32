import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/generateTable")
public class Table extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = request.getParameter("title");
        String rowsStr = request.getParameter("rows");
        String colsStr = request.getParameter("cols");
        String bgcolor = request.getParameter("bg");
        int rows = (rowsStr != null) ? Integer.parseInt(rowsStr) : 3;
        int cols = (colsStr != null) ? Integer.parseInt(colsStr) : 3;
        bgcolor = (bgcolor != null) ? bgcolor : "#FFFFFF";
        out.println("<html>");
        out.println("<head><title>" + title + "</title></head>");
        out.println("<body>");
        out.println("<h2>" + title + "</h2>");
        out.println("<table border='1' cellspacing='0' cellpadding='5' style='background-color:" + bgcolor + ";'>");
        for (int i = 0; i < rows; i++) {
            out.println("<tr>");
            for (int j = 0; j < cols; j++) {
                out.println("<td> </td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}