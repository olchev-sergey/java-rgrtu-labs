package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.Hobby;
import tacos.Person;

@Repository
public class JdbcPersonRepository implements PersonRepository {

  private JdbcTemplate jdbc;

  public JdbcPersonRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }

  @Override
  public Person save(Person person) {
    long tacoId = saveTacoInfo(person);
    person.setId(tacoId);
    for (Hobby hobby : person.getHobbies()) {
      saveIngredientToTaco(hobby, tacoId);
    }

    return person;
  }

  private long saveTacoInfo(Person person) {
    person.setCreatedAt(new Date());
    PreparedStatementCreator psc =
        new PreparedStatementCreatorFactory(
            "insert into Person (name, createdAt) values (?, ?)",
            Types.VARCHAR, Types.TIMESTAMP
        ).newPreparedStatementCreator(
            Arrays.asList(
                person.getName(),
                new Timestamp(person.getCreatedAt().getTime())));

    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbc.update(psc, keyHolder);

    return keyHolder.getKey().longValue();
  }

  private void saveIngredientToTaco(
          Hobby hobby, long tacoId) {
    jdbc.update(
        "insert into Person_Hobbies (person, hobby) " +
        "values (?, ?)",
        tacoId, hobby.getId());
  }

}
