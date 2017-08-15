package ua.kiev.prog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
    private AtomicInteger m = new AtomicInteger(0);
    private AtomicInteger g = new AtomicInteger(0);


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        String name = req.getParameter("first");
        String last = req.getParameter("last");
        String age = req.getParameter("age");
        String men = req.getParameter("tip");
        if (men.equals("Ж")) {
            g.incrementAndGet();
        } else if (men.equals("М")) {
            m.incrementAndGet();
        }
        PrintWriter pr = resp.getWriter();
        pr.println("<h3> Имя: " + name + "</h3>");
        pr.println("<h3> Фамилия: " + last + "</h3>");
        pr.println("<h3> возраст: " + age + "</h3>");
        pr.println("<h3> пол: " + men + "</h3>");
        pr.println("<h1> Статистика</h1>");
        pr.println("<h2> Количество мужчин среди проголосовавших: " + m.get() +"</h3>");
        pr.println("<h2> Количество женщин среди проголосовавших: " + g.get() +"</h3>");
        pr.println("<h5>  <a href=\"index.html\">еще раз</a></h3>");
    }
}
