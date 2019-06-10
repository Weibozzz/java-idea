package cn.liuweibo.web;

import cn.liuweibo.dao.UserDao;
import cn.liuweibo.demain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        System.out.println("1");
        UserDao dao = new UserDao();
        System.out.println("2");
        User user = dao.login(loginUser);
        if (user == null) {
            System.out.println("登录失败");
            request.getRequestDispatcher("/failServlet");
        } else {
            System.out.println("登录成功");
            request.setAttribute("user",user); // 存储
            request.getRequestDispatcher("/successServlet"); //转发
        }
    }
}
