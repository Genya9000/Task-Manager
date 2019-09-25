package ml.khaliman.controller;
import ml.khaliman.model.User;
import ml.khaliman.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {
    private User user= new User();
    @Autowired
    private TaskService taskService;


    @PostMapping("/signup")
    public String onSignUp(Model model, @RequestParam String userName, @RequestParam String userLogin,
                           @RequestParam String userPassword, HttpSession httpSession) {
    model.addAttribute("name", userName);

taskService.addUser(User.builder().name(userName).login(userLogin).password(userPassword).build());
        httpSession.setAttribute("user", user);
return "user";
}
}
