// tag::testShowDesignForm[]
package hobbies;
import static org.mockito.Mockito.verify;
import static 
    org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static 
    org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import hobbies.Hobby.Type;
import hobbies.web.DesignHobbyController;

//tag::testProcessForm[]
@RunWith(SpringRunner.class)
@WebMvcTest(DesignHobbyController.class)
public class DesignPersonControllerTest {
//end::testProcessForm[]

  @Autowired
  private MockMvc mockMvc;
  
  private List<Hobby> hobbies;

//end::testShowDesignForm[]

  /*
//tag::testProcessForm[]
   ...

//end::testProcessForm[]
 */

//tag::testProcessForm[]
  private Person design;

//end::testProcessForm[]

//tag::testShowDesignForm[]
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
    
//end::testShowDesignForm[]
    
    design = new Person();
    design.setName("Test Taco");
    design.setHobbies(Arrays.asList("FLTO", "GRBF", "CHED"));
//tag::testShowDesignForm[]
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
//end::testShowDesignForm[]

  /*
//tag::testProcessForm[]
   ...

//end::testProcessForm[]
 */
  
//tag::testProcessForm[]
  @Test
  public void processDesign() throws Exception {
    mockMvc.perform(post("/design")
        .content("name=Test+Taco&ingredients=FLTO,GRBF,CHED")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
        .andExpect(status().is3xxRedirection())
        .andExpect(header().stringValues("Location", "/orders/current"));
  }

//tag::testShowDesignForm[]
}
//end::testShowDesignForm[]
//end::testProcessForm[]
