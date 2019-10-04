package ml.khaliman.controller;
import ml.khaliman.model.Task;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

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
            session.setAttribute("userName", userName);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(60 * 60 * 24 * 10);
            System.out.println(session.getId());
            model.addAttribute("name", session.getAttribute("userName"));
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
            System.out.println("user exist");
            User user = (User) taskService.findUser(userLogin);
            System.out.println(user.toString());
            if (userPassword.equals(user.getPassword())) {

                session = req.getSession();
                session.setAttribute("userName", user.getName());
                session.setAttribute("user", user);
                session.setAttribute("login", user.getLogin());

                session.setMaxInactiveInterval(60 * 60 * 24 * 10);
                System.out.println(session.getAttribute("user").toString());
                model.addAttribute("name", session.getAttribute("userName"));
                model.addAttribute("tasks", taskService.listTasks(user));

                return "user";
            }
        } else model.addAttribute("signUpError", "The password does not match the login, try another option");
        return "index";
    }

    @PostMapping("/create")
    public String createTask(Model model, @RequestParam Date userDate, @RequestParam String userText,
                             HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Иду");
        User user1 = (User) session.getAttribute("user");
        System.out.println(user1.toString());
        Task task = Task.builder().user(user1).date(userDate).text(userText).build();
        System.out.println(task.toString());
        taskService.addTask(task);
        List<Task> tasks = taskService.listTasks(user1);
        System.out.println(tasks.toString());
        model.addAttribute("name", user1.getName());
        model.addAttribute("tasks", tasks);

        return "user";
    }
    @PostMapping("/deleteUpdate")
    public String onSignIn(Model model, @RequestParam long[] checkbox, @RequestParam String submit,
                            HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (submit.equals("delete")) {
            taskService.deleteTask(checkbox);
        }
        else {

        }
        return "user";
    }
}