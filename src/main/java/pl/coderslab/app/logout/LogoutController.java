package pl.coderslab.app.logout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/logout")
@SessionAttributes("userSession")
public class LogoutController {

    @GetMapping("")
    public String logout(Model model, HttpServletRequest request,  HttpServletResponse response) {
        Cookie c = WebUtils.getCookie(request, "JSESSIONID");
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);
        model.addAttribute("userSession", null);
        return "logout";
    }
}
