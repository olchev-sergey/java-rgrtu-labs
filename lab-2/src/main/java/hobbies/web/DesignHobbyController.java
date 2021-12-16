// tag::head[]
package hobbies.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import hobbies.Hobby;
import hobbies.Hobby.Type;
import hobbies.Person;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignHobbyController {

//end::head[]

  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    List<Hobby> hobbies = Arrays.asList(
            new Hobby("B1", "С понедельника", Type.SUPPOSE_START_TIME),
            new Hobby("B2", "Завтра точно начну", Type.SUPPOSE_START_TIME),
            new Hobby("B1", "3 раза в неделю", Type.BUSYNESS),
            new Hobby("B2", "1 раз в неделю", Type.BUSYNESS),
            new Hobby("B3", "6 раз в нееделю", Type.BUSYNESS),
            new Hobby("K1", "Спорт", Type.KIND),
            new Hobby("K2", "Творчество", Type.KIND),
            new Hobby("K3", "Самообразование", Type.KIND)
    );

    Type[] types = Hobby.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
              filterByType(hobbies, type));
    }
  }

  //tag::showDesignForm[]
  @GetMapping
  public String showDesignForm(Model model) {
    model.addAttribute("design", new Person());
    return "design";
  }

//end::showDesignForm[]

/*
//tag::processDesign[]
  @PostMapping
  public String processDesign(Design design) {
    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
  }

//end::processDesign[]
 */

  //tag::processDesignValidated[]
  @PostMapping
  public String processDesign(@Valid @ModelAttribute("design") Person design, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "design";
    }

    // Save the taco design...
    // We'll do this in chapter 3
    log.info("Processing design: " + design);

    return "redirect:/orders/current";
  }

//end::processDesignValidated[]

  //tag::filterByType[]
  private List<Hobby> filterByType(
          List<Hobby> hobbies, Type type) {
    return hobbies
            .stream()
            .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());
  }

//end::filterByType[]
// tag::foot[]
}
// end::foot[]
