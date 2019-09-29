package ml.khaliman.controller;
import ml.khaliman.model.User;
import ml.khaliman.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

@org.springframework.stereotype.Controller
public class Controller {
    private HttpSession session;
    @Autowired
    private TaskService taskService;

    @PostMapping("/signup")
    public String onSignUp(Model model, @RequestParam String userName, @RequestParam String userLogin,
                           @RequestParam String userPassword, HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!taskService.ifExist(userLogin)) {
            User user = User.builder().name(userName).login(userLogin).password(userPassword).build();
            taskService.addUser(user);
            session = req.getSession();
            session.setAttribute("user", userName);
            session.setMaxInactiveInterval(60 * 60 * 24 * 10);
            System.out.println(session.getId());
            model.addAttribute("name", session.getAttribute("user"));
            return "user";
        } else model.addAttribute("signUpError", "A user with that username already exists,\n" +
                "try to choose another login");
        return "index";
    }

    @GetMapping("/logOut")
    public String logOut() {
        session.invalidate();
        return "redirect:index.html";
    }

    @PostMapping("/signIn")
    public String onSignIn(Model model, @RequestParam String userLogin,
                           @RequestParam String userPassword, HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (taskService.ifExist(userLogin)) {
        User user = (User) taskService.findUser(userLogin);
        if(userPassword.equals(user.getPassword())) {
            session = req.getSession();
            session.setAttribute("user", user.getName());
            session.setMaxInactiveInterval(60 * 60 * 24 * 10);
            System.out.println(session.getId());
            model.addAttribute("name", session.getAttribute("user"));

            return "user";
        }}
        else model.addAttribute("signUpError", "The password does not match the login, try another option");
        return "index";
    }
}