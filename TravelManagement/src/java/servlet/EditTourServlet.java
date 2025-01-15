@WebServlet("/EditTourServlet")
public class EditTourServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String id = request.getParameter("id");
        TourDAO tourDAO = new TourDAO();
        Tour tour = tourDAO.getTourById(id);
        
        if (tour != null) {
            request.setAttribute("tour", tour);
            request.getRequestDispatcher("editTour.jsp").forward(request, response);
        } else {
            response.sendRedirect("TourListServlet");
        }
    }
}