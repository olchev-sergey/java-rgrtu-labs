// tag::classShell[]
package tacos.data;
//end::classShell[]
import java.sql.ResultSet;
import java.sql.SQLException;
//tag::classShell[]

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tacos.Hobby;

@Repository
public class JdbcHobbyRepository
    implements HobbyRepository {

  //tag::jdbcTemplate[]
  private JdbcTemplate jdbc;
  
  //end::jdbcTemplate[]

  @Autowired
  public JdbcHobbyRepository(JdbcTemplate jdbc) {
    this.jdbc = jdbc;
  }
//end::classShell[]

  //tag::finders[]
  @Override
  public Iterable<Hobby> findAll() {
    return jdbc.query("select id, name, type from Hobby",
        this::mapRowToIngredient);
  }

  // tag::findOne[]
  @Override
  public Hobby findById(String id) {
    return jdbc.queryForObject(
        "select id, name, type from Hobby where id=?",
        this::mapRowToIngredient, id);
  }
  
  // end::findOne[]
  
  //end::finders[]

  /*
  //tag::preJava8RowMapper[]
  @Override
  public Ingredient findOne(String id) {
    return jdbc.queryForObject(
        "select id, name, type from Ingredient where id=?",
        new RowMapper<Ingredient>() {
          public Ingredient mapRow(ResultSet rs, int rowNum) 
              throws SQLException {
            return new Ingredient(
                rs.getString("id"), 
                rs.getString("name"),
                Ingredient.Type.valueOf(rs.getString("type")));
          };
        }, id);
  }
  //end::preJava8RowMapper[]
   */
  
  //tag::save[]
  @Override
  public Hobby save(Hobby hobby) {
    jdbc.update(
        "insert into Hobby (id, name, type) values (?, ?, ?)",
        hobby.getId(),
        hobby.getName(),
        hobby.getType().toString());
    return hobby;
  }
  //end::save[]

  // tag::findOne[]
  //tag::finders[]
  private Hobby mapRowToIngredient(ResultSet rs, int rowNum)
      throws SQLException {
    return new Hobby(
        rs.getString("id"), 
        rs.getString("name"),
        Hobby.Type.valueOf(rs.getString("type")));
  }
  //end::finders[]
  // end::findOne[]

  
  /*
//tag::classShell[]

  ...
//end::classShell[]
   */
//tag::classShell[]

}
//end::classShell[]
