package tacos;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import tacos.Hobby.Type;
import tacos.data.HobbyRepository;
import tacos.data.OrderRepository;
import tacos.data.PersonRepository;
import tacos.web.DesignHobbyController;

@RunWith(SpringRunner.class)
@WebMvcTest(DesignHobbyController.class)
public class DesignPersonControllerTest {

  @Autowired
  private MockMvc mockMvc;

  private List<Hobby> hobbies;

  private Person design;

  @MockBean
  private HobbyRepository hobbyRepository;

  @MockBean
  private PersonRepository designRepository;

  @MockBean
  private OrderRepository orderRepository;

  @Before
  public void setup() {
    hobbies = Arrays.asList(
      new Hobby("FLTO", "Flour Tortilla", Type.WRAP),
      new Hobby("COTO", "Corn Tortilla", Type.WRAP),
      new Hobby("GRBF", "Ground Beef", Type.PROTEIN),
      new Hobby("CARN", "Carnitas", Type.PROTEIN),
      new Hobby("TMTO", "Diced Tomatoes", Type.VEGGIES),
      new Hobby("LETC", "Lettuce", Type.VEGGIES),
      new Hobby("CHED", "Cheddar", Type.CHEESE),
      new Hobby("JACK", "Monterrey Jack", Type.CHEESE),
      new Hobby("SLSA", "Salsa", Type.SAUCE),
      new Hobby("SRCR", "Sour Cream", Type.SAUCE)
    );

    when(hobbyRepository.findAll())
        .thenReturn(hobbies);

    when(hobbyRepository.findById("FLTO")).thenReturn(new Hobby("FLTO", "Flour Tortilla", Type.WRAP));
    when(hobbyRepository.findById("GRBF")).thenReturn(new Hobby("GRBF", "Ground Beef", Type.PROTEIN));
    when(hobbyRepository.findById("CHED")).thenReturn(new Hobby("CHED", "Cheddar", Type.CHEESE));

    design = new Person();
    design.setName("Test Taco");

    design.setHobbies(
        Arrays.asList(
            new Hobby("FLTO", "Flour Tortilla", Type.WRAP),
            new Hobby("GRBF", "Ground Beef", Type.PROTEIN),
            new Hobby("CHED", "Cheddar", Type.CHEESE)));

  }

  @Test
  public void testShowDesignForm() throws Exception {
    mockMvc.perform(get("/design"))
        .andExpect(status().isOk())
        .andExpect(view().name("design"))
        .andExpect(model().attribute("wrap", hobbies.subList(0, 2)))
        .andExpect(model().attribute("protein", hobbies.subList(2, 4)))
        .andExpect(model().attribute("veggies", hobbies.subList(4, 6)))
        .andExpect(model().attribute("cheese", hobbies.subList(6, 8)))
        .andExpect(model().attribute("sauce", hobbies.subList(8, 10)));
  }

  @Test
  public void processDesign() throws Exception {
    when(designRepository.save(design))
        .thenReturn(design);

    mockMvc.perform(post("/design")
        .content("name=Test+Taco&ingredients=FLTO,GRBF,CHED")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().stringValues("Location", "/orders/current"));
  }

}
