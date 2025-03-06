package joonseo.final_Budget.domain;
import java.io.Serializable;

public class Expense implements Serializable {
    private ExpenseCategory category; // ENUM 유지
    private int amount;
    private String description;

    public Expense(ExpenseCategory category, int amount, String description) {
        this.category = category;
        this.amount = amount;
        this.description = description;
    }

    public ExpenseCategory getCategory() { return category; }
    public int getAmount() { return amount; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return category + ": " + amount + "원 (" + description + ")";
    }
}

