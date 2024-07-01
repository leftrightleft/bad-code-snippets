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
