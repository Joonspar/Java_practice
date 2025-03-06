package joonseo.final_Budget.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Info implements Serializable {
    private LocalDate expenseDate; // 지출 날짜
    private int totalExpend; // 총 비용
    private List<Expense> expenses; // 개별 지출 목록

    public Info(LocalDate expenseDate, int expectedBudget) {
        this.expenseDate = expenseDate;
        this.totalExpend = 0;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(ExpenseCategory category, int amount, String description) {
        Expense newExpense = new Expense(category, amount, description);
        expenses.add(newExpense);
        totalExpend += amount;
    }

    public LocalDate getExpenseDate() { return expenseDate; }
    public int getTotalExpend() { return totalExpend; }
    public List<Expense> getExpenses() { return expenses; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("지출 날짜: ").append(expenseDate).append("\n");
        sb.append("총 지출: ").append(totalExpend).append("원\n");
        sb.append("지출 내역:\n");

        for (Expense expense : expenses) {
            sb.append("- ").append(expense).append("\n");
        }

        return sb.toString();
    }
}
