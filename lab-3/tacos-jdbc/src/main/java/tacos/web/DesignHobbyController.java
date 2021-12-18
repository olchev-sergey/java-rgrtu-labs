package tacos.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tacos.Hobby;
import tacos.Person;
import tacos.Hobby.Type;
import tacos.Order;
import tacos.data.PersonRepository;
import tacos.data.HobbyRepository;

// tag::classShell[]
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignHobbyController {
  
//end::classShell[]

//tag::bothRepoProperties[]
//tag::ingredientRepoProperty[]
  private final HobbyRepository hobbyRepo;
  
//end::ingredientRepoProperty[]
  private PersonRepository designRepo;

//end::bothRepoProperties[]
  
  /*
// tag::ingredientRepoOnlyCtor[]
  @Autowired
  public DesignTacoController(IngredientRepository ingredientRepo) {
    this.ingredientRepo = ingredientRepo;
  }
// end::ingredientRepoOnlyCtor[]
   */

  //tag::bothRepoCtor[]
  @Autowired
  public DesignHobbyController(
        HobbyRepository hobbyRepo,
        PersonRepository designRepo) {
    this.hobbyRepo = hobbyRepo;
    this.designRepo = designRepo;
  }

  //end::bothRepoCtor[]
  
  // tag::modelAttributes[]
  @ModelAttribute(name = "order")
  public Order order() {
    return new Order();
  }
  
  @ModelAttribute(name = "person")
  public Person person() {
    return new Person();
  }

  // end::modelAttributes[]
  // tag::showDesignForm[]
  
  @GetMapping
  public String showDesignForm(Model model) {
    List<Hobby> hobbies = new ArrayList<>();
    hobbyRepo.findAll().forEach(i -> hobbies.add(i));
    
    Type[] types = Hobby.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(), 
          filterByType(hobbies, type));
    }

    return "design";
  }
//end::showDesignForm[]

  //tag::processDesign[]
  @PostMapping
  public String processDesign(
          @Valid Person design, Errors errors,
          @ModelAttribute Order order) {

    if (errors.hasErrors()) {
      return "design";
    }

    Person saved = designRepo.save(design);
    order.addDesign(saved);

    return "redirect:/orders/current";
  }
  //end::processDesign[]
  
  private List<Hobby> filterByType(
          List<Hobby> hobbies, Type type) {
    return hobbies
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

  /*
//tag::classShell[]

  ...

//end::classShell[]
   */
//tag::classShell[]

}
//end::classShell[]
