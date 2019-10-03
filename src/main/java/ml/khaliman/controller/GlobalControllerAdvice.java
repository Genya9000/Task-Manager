package ml.khaliman.controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(assignableTypes=Controller.class)
public class GlobalControllerAdvice {
    @ModelAttribute("i")
    public Long getI(){
        return 0L;
    }
}
