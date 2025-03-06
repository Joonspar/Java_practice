package joonseo.final_Budget.persistance;

import joonseo.final_Budget.domain.Info;
import joonseo.final_Budget.domain.Expense;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    private final DataStorage dataStorage;
    private final List<Info> infoList;

    public DataRepository(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.infoList = dataStorage.loadExpenses();
    }

    public List<Info> selectAllInfo() {
        return new ArrayList<>(infoList);
    }

    public Info selectInfoByDate(LocalDate date) {
        return infoList.stream()
                .filter(info -> info.getExpenseDate().equals(date))
                .findFirst()
                .orElse(null);
    }

    public void insertInfo(Info info) {
        infoList.add(info);
        dataStorage.saveExpenses(infoList);
    }

    public void updateInfo(LocalDate date, Expense newExpense) {
        boolean updated = false;
        for (Info info : infoList) {
            if (info.getExpenseDate().equals(date)) {
                info.addExpense(newExpense.getCategory(), newExpense.getAmount(), newExpense.getDescription());
                updated = true;
                break;
            }
        }
        if (updated) {
            dataStorage.saveExpenses(infoList);
        }
    }
}
