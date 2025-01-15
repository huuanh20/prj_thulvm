@WebServlet("/UpdateTourServlet")
public class UpdateTourServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            Tour tour = new Tour();
            tour.setId(request.getParameter("id"));
            tour.setName(request.getParameter("name"));
            tour.setDestination(request.getParameter("destination"));
            tour.setPrice(Float.parseFloat(request.getParameter("price")));
            tour.setDuration(Integer.parseInt(request.getParameter("duration")));
            tour.setSeats(Integer.parseInt(request.getParameter("seats")));
            
            // Validation
            if (tour.getPrice() <= 0 || tour.getDuration() <= 0 || tour.getSeats() < 0) {
                throw new IllegalArgumentException("Invalid input values");
            }
            
            TourDAO tourDAO = new TourDAO();
            if (tourDAO.updateTour(tour)) {
                response.sendRedirect("TourListServlet");
            } else {
                request.setAttribute("error", "Update failed");
                request.setAttribute("tour", tour);
                request.getRequestDispatcher("editTour.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Invalid input. Please check your values.");
            request.getRequestDispatcher("editTour.jsp").forward(request, response);
        }
    }
}