package hobbies;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Hobby {
  
  private final String id;
  private final String name;
  private final Type type;
  
  public static enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE,
    FOOTBALL, BASKETBALL, MUSIC, COOKING, DRAWING, PHOTO, TIME,
    KIND, BUSYNESS, DAY_COUNT, SUPPOSE_START_TIME
  }

}
