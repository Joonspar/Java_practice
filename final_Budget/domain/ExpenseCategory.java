package joonseo.final_Budget.domain;

public enum ExpenseCategory {
    FOOD, // 식비
    ENTERTAINMENT, // 유흥
    TRANSPORT, // 교통비
    SHOPPING, // 쇼핑
    OTHERS; // 기타
    public static ExpenseCategory fromString(String category) {
        return switch (category.toUpperCase()) {
            case "FOOD" -> FOOD;
            case "ENTERTAINMENT" -> ENTERTAINMENT;
            case "TRANSPORT" -> TRANSPORT;
            case "SHOPPING" -> SHOPPING;
            case "OTHERS" -> OTHERS;
            default -> throw new IllegalArgumentException("Invalid Expense Category: " + category);
        };
    }

}
