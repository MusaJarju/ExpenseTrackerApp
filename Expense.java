// Expense.java (Model)
public class Expense {
    private int id;
    private double amount;
    private String category;
    private String description;
    private String date; // format: YYYY-MM-DD

    // Constructors, Getters, and Setters
    public Expense(double amount, String category, String description, String date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Expense(int id, double amount, String category, String description, String date) {
        this(amount, category, description, date);
        this.id = id;
    }


}
