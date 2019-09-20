package ml.khaliman.controller;
import ml.khaliman.model.User;
import ml.khaliman.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private TaskService taskService;

@RequestMapping(value = "signup", method = RequestMethod.POST)
    public String onSignUp(Model model, @RequestParam String userName, @RequestParam String userLogin,
                           @RequestParam String userPassword) {
    model.addAttribute("name", userName);
taskService.addUser(User.builder().name(userName).login(userLogin).password(userPassword).build());
return "user";
}
}
