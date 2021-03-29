package com.tts.signuplist.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SignUpController
{
    @Autowired
    private SignUpRepository signupRepository;

    @GetMapping(value = "/")
    public String index(SignUp signup)
    {
        return "SignUp/index";
    }

    private SignUp signup;

    @PostMapping(value = "/")
    public String addNewSignUp(SignUp signup, Model model)
    {

        signupRepository.save(new SignUp(signup.getFirstName(), signup.getLastName(), signup.getUserName(), signup.getSignedUp()));
        model.addAttribute("firstName", signup.getFirstName());
        model.addAttribute("lastName", signup.getLastName());
        model.addAttribute("userName", signup.getUserName());
        return "signup/result";
    }

}
