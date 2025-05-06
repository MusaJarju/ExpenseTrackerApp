// ExpenseTrackerApp.java (Main Class)
import java.util.*;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n💐💐💐 Welcome To Expense TrackerApp 💐💐💐");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Category: ");
                        String category = sc.nextLine();
                        System.out.print("Description: ");
                        String description = sc.nextLine();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        dao.addExpense(new Expense(amount, category, description, date));
                        System.out.println("\uD83C\uDF39 Expense added successfully.");
                    }
                    case 2 -> {
                        List<Expense> expense = dao.getAllExpenses();
                        System.out.println("📢 My Expenses are : ");
                        for (Expense e : expense) {

                            System.out.println("[ ID : " + e.getId() + " ] " + "D" + e.getAmount() + " -- " + e.getCategory() + "[" + e.getDescription() + "]"+ "📅 " + e.getDate());
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Amount: ");
                        double amount = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("New Category: ");
                        String category = sc.nextLine();
                        System.out.print("New Description: ");
                        String description = sc.nextLine();
                        System.out.print("New Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        dao.updateExpense(id, new Expense(amount, category, description, date));
                        System.out.println("🌹🎊 Expense updated.");
                    }
                    case 4 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        dao.deleteExpense(id);
                        System.out.println("📢 Expense deleted.");
                    }
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("🔥 Error: " + e.getMessage());
            }
        }
    }
}
