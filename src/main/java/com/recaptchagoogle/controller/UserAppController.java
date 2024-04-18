package com.recaptchagoogle.controller;

import com.recaptchagoogle.dto.UserAppDto;
import com.recaptchagoogle.entities.UserApp;
import com.recaptchagoogle.service.impl.RecaptchaServiceImpl;
import com.recaptchagoogle.service.impl.UserAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserAppController {

    @Autowired
    private UserAppServiceImpl userAppService;

    @Autowired
    private RecaptchaServiceImpl recaptchaService;

    @GetMapping(path = {"/"})
    public String UserAppAll(Model model){

        List<UserApp> userAppList = userAppService.findAll();

        model.addAttribute("userAppList", userAppList);

        return "index";
    }

    @GetMapping(path = "/formsave")
    public String saveUserApp(Model model){

        model.addAttribute("userApp", new UserApp());

        return "formsave";
    }

    @PostMapping(path = "/save")
    public String saveUserApp(@ModelAttribute(name="userApp") UserAppDto userAppDto, @RequestParam(name = "g-recaptcha-response") String captcha, Model model){

        boolean valid = recaptchaService.validateRecaptcha(captcha);

        if (valid){
            UserApp userApp = UserApp.builder()
                    .name(userAppDto.getName())
                    .lastname(userAppDto.getLastname())
                    .age(userAppDto.getAge()).build();

            userAppService.saveUserApp(userApp);
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "Captcha invalido");

            return "error";
        }
    }

}
