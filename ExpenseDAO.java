// ExpenseDAO.java (Handles DB operations)
import java.sql.*;
import java.util.*;

public class ExpenseDAO {
    private final String url = "jdbc:mysql://localhost:3306/expense_tracker";
    private final String user = "root";
    private final String password = "password";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addExpense(Expense expense) throws SQLException {
        String sql = "INSERT INTO expense (amount, category, description, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getCategory());
            stmt.setString(3, expense.getDescription());
            stmt.setString(4, expense.getDate());
            stmt.executeUpdate();
        }
    }

    public List<Expense> getAllExpenses() throws SQLException {
        List<Expense> list = new ArrayList<>();
        String sql = "SELECT * FROM expense";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getString("date")
                );
                list.add(e);
            }
        }
        return list;
    }

    public void updateExpense(int id, Expense expense) throws SQLException {
        String sql = "UPDATE expense SET amount=?, category=?, description=?, date=? WHERE id=?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, expense.getAmount());
            stmt.setString(2, expense.getCategory());
            stmt.setString(3, expense.getDescription());
            stmt.setString(4, expense.getDate());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        }
    }

    public void deleteExpense(int id) throws SQLException {
        String sql = "DELETE FROM expense WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}