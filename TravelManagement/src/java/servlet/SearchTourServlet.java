@WebServlet("/SearchTourServlet")
public class SearchTourServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            float maxPrice = Float.parseFloat(request.getParameter("maxPrice"));
            TourDAO tourDAO = new TourDAO();
            List<Tour> tours = tourDAO.searchByPrice(maxPrice);
            request.setAttribute("tours", tours);
            request.getRequestDispatcher("tourList.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid price format");
            request.getRequestDispatcher("tourList.jsp").forward(request, response);
        }
    }
}