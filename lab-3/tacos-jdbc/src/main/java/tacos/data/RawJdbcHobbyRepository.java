package tacos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import tacos.Hobby;

/**
 * Raw implementation of {@link HobbyRepository} for
 * comparison with {@link JdbcHobbyRepository} to illustrate
 * the power of using {@link JdbcTemplate}. 
 * @author habuma
 */
public class RawJdbcHobbyRepository implements HobbyRepository {

  private DataSource dataSource;

  public RawJdbcHobbyRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }
  
  @Override
  public Iterable<Hobby> findAll() {
    List<Hobby> hobbies = new ArrayList<>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = dataSource.getConnection();
      statement = connection.prepareStatement(
          "select id, name, type from Hobby");
      resultSet = statement.executeQuery();
      while(resultSet.next()) {
        Hobby hobby = new Hobby(
            resultSet.getString("id"),
            resultSet.getString("name"),
            Hobby.Type.valueOf(resultSet.getString("type")));
        hobbies.add(hobby);
      }      
    } catch (SQLException e) {
      // ??? What should be done here ???
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {}
      }
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {}
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {}
      }
    }
    return hobbies;
  }
  
  // tag::rawfindOne[]
  @Override
  public Hobby findById(String id) {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = dataSource.getConnection();
      statement = connection.prepareStatement(
          "select id, name, type from Hobby");
      statement.setString(1, id);
      resultSet = statement.executeQuery();
      Hobby hobby = null;
      if(resultSet.next()) {
        hobby = new Hobby(
            resultSet.getString("id"),
            resultSet.getString("name"),
            Hobby.Type.valueOf(resultSet.getString("type")));
      } 
      return hobby;
    } catch (SQLException e) {
      // ??? What should be done here ???
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {}
      }
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {}
      }
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {}
      }
    }
    return null;
  }
  // end::rawfindOne[]
  
  @Override
  public Hobby save(Hobby hobby) {
    // TODO: I only needed one method for comparison purposes, so
    //       I've not bothered implementing this one (yet).
    return null;
  }
  
}
