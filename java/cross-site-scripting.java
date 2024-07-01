import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/xss")
public class XSS extends HttpServlet {
    // Existing doGet method
}

public class XSS extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Extract the parameter in a separate method to simulate data flow
        String page = extractParameter(request);

        // BAD: a request parameter is written directly to the Servlet response stream
        response.getWriter().print(
                "The page \"" + page + "\" was not found.");
    }

    // Method to simulate data flow from an untrusted source
    private String extractParameter(HttpServletRequest request) {
        return request.getParameter("page");
    }
}
