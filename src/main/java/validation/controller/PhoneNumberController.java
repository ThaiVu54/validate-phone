package validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import validation.model.PhoneNumber;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
//@RequestMapping(value = {"/phones", ""})
public class PhoneNumberController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phone", new PhoneNumber());
        return "/index";
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {

            return "/index";
        } else{
            model.addAttribute("phone",phoneNumber);
            return "/result";
        }
    }
}
