package ml.khaliman.controller;

import ml.khaliman.dao.TaskDAOImpl;
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
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {
    private HttpSession session;
    private User user;
    private Task task;
    @Autowired
    private TaskService taskService;

    @PostMapping("/signup")
    public String onSignUp(Model model, @RequestParam(required = false) String userName, @RequestParam String userLogin,
                           @RequestParam String userPassword, @RequestParam(required = false) String saveMe, HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!taskService.ifExist(userLogin)) {
            user = User.builder().name(userName).login(userLogin).password(userPassword).build();
            taskService.addUser(user);
            session = req.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("user", user);
            if ("Yes".equals(saveMe)) {
                session.setMaxInactiveInterval(60 * 60 * 24 * 10);
            } else session.setMaxInactiveInterval(-1);
            System.out.println(session.getId());
            model.addAttribute("name", session.getAttribute("userName"));
            model.addAttribute("i", 0);
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
                           @RequestParam String userPassword, @RequestParam(required = false) String saveMe, HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (taskService.ifExist(userLogin)) {
            System.out.println("user exist");
            user = (User) taskService.findUser(userLogin);
            System.out.println(user.toString());
            if (userPassword.equals(user.getPassword())) {
                session = req.getSession();
                session.setAttribute("userName", user.getName());
                session.setAttribute("user", user);
                session.setAttribute("login", user.getLogin());
                if ("Yes".equals(saveMe)) {
                    session.setMaxInactiveInterval(60 * 60 * 24 * 10);
                } else session.setMaxInactiveInterval(-1);
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
        System.out.println(user.toString());
        task = Task.builder().user(user).date(userDate).text(userText).build();
        System.out.println(task.toString());
        taskService.addTask(task);
        List<Task> tasks = taskService.listTasks(user);
        System.out.println(tasks.toString());
        model.addAttribute("name", user.getName());
        model.addAttribute("tasks", tasks);
        return "user";
    }

    @PostMapping("/deleteUpdate")
    public String onSignIn(Model model, @RequestParam(required = false) long[] checkbox, @RequestParam String submit, @RequestParam(required = false) String userText,
                           HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (submit.equals("Delete") & (checkbox != null)) {
            taskService.deleteTask(checkbox);
        } else if (submit.equals("Update")) {
            taskService.updateTask(checkbox[0], userText);
        } else if (checkbox == null) {
            model.addAttribute("tasks", taskService.listTasks(user));
            model.addAttribute("name", user.getName());
        }
        model.addAttribute("tasks", taskService.listTasks(user));
        model.addAttribute("name", user.getName());
        model.addAttribute("i", 0);
        return "user";
    }

    @GetMapping("/pagination")
    public String pageCount(Model model, @RequestParam int page, HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TaskDAOImpl.pageNumber = page;
        model.addAttribute("tasks", taskService.listTasks(user));
        model.addAttribute("name", user.getName());
        if (page == 1)
            return "user";
        else if (page == 2) return "user2";
        return "user3";
    }

    @GetMapping("/")
    public String isSave(Model model) {
        if (session.isNew()) {
            System.out.println("сессии нет");
            return "redirect:index.html";
        } else {
            System.out.println("сессия есть");
            model.addAttribute("name", session.getAttribute("userName"));
            model.addAttribute("tasks", taskService.listTasks((User) session.getAttribute("user")));
            return "user";
        }
    }
}