package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.LoginService;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })

public class LoginServlet extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");

    String password = request.getParameter("password");
    LoginService loginService = new LoginService();

    boolean result = loginService.authenticate(email, password);
    boolean resultEmail = loginService.validateEmail(email);
    User user = loginService.getUserByEmail(email);
    if (result == true && resultEmail == true) {
      request.getSession().setAttribute("user", user);
      response.sendRedirect("home.jsp");
    } else {
      response.sendRedirect("login.jsp");
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Short description";
  }
}