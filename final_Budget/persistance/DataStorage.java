package joonseo.final_Budget.persistance;

import joonseo.final_Budget.domain.Info;
import java.util.List;

public interface DataStorage {
    void saveExpenses(List<Info> expenses);
    List<Info> loadExpenses();
}
