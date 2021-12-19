package ru.rsreu.hobbies.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ru.rsreu.hobbies.Hobby;
import ru.rsreu.hobbies.Hobby.Type;
import ru.rsreu.hobbies.Person;
import ru.rsreu.hobbies.Order;
import ru.rsreu.hobbies.User;
import ru.rsreu.hobbies.data.HobbyRepository;
import ru.rsreu.hobbies.data.PersonRepository;
import ru.rsreu.hobbies.data.UserRepository;

import javax.validation.Valid;

//@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignHobbyController {

    private final HobbyRepository hobbyRepo;

    private PersonRepository personRepository;

    private UserRepository userRepo;

    @Autowired
    public DesignHobbyController(
            HobbyRepository hobbyRepo,
            PersonRepository drugFeeRepo,
            UserRepository userRepo){
        this.hobbyRepo = hobbyRepo;
        this.personRepository = drugFeeRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Person design(){
        return new Person();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        List<Hobby> constituents = new ArrayList<>();
        hobbyRepo.findAll().forEach(i -> constituents.add(i));

        Type[] types = Hobby.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(constituents, type));
        }

        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Person person, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Person saved = personRepository.save(person);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Hobby> filterByType(
            List<Hobby> constituents, Type type) {
        return constituents
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
