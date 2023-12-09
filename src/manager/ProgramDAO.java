package manager;

import domain.Program;
import repository.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO {
    private static final String SELECT_ALL_PROGRAMS = "SELECT * FROM magazine.public.magazine";
    private static final String INSERT_PROGRAM = "INSERT INTO magazine.public.magazine (department_name, hours_of_operation, product_name, price) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PROGRAM = "UPDATE magazine.public.magazine SET department_name = ?, hours_of_operation = ?, product_name = ?, price = ? WHERE id = ?";
    private static final String DELETE_PROGRAM = "DELETE FROM magazine.public.magazine WHERE id = ?";

    public List<Program> getAllPrograms() {
        List<Program> programs = new ArrayList<>();

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PROGRAMS);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Program program = new Program();
                program.setId(resultSet.getInt("id"));
                program.setDepatment_name(resultSet.getString("department_name"));
                program.setProduct_name(resultSet.getString("product_name"));
                program.setPrice(resultSet.getInt("price"));
                program.setHours_of_operation(resultSet.getString("hours_of_operation"));

                programs.add(program);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return programs;
    }

    public void addProgram(Program program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_PROGRAM)) {

            statement.setString(1, program.getDepartment_name());
            statement.setString(3, program.getProduct_name());
            statement.setInt(4, program.getPrice());
            statement.setString(2, program.getHours_of_operation());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgram(Program program) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PROGRAM)) {

            statement.setString(1, program.getDepartment_name());
            statement.setString(3, program.getProduct_name());
            statement.setInt(4, program.getPrice());
            statement.setString(2, program.getHours_of_operation());
            statement.setInt(6, program.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgram(int id) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PROGRAM)) {

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Другие методы для обновления, удаления и редактирования программ
}
