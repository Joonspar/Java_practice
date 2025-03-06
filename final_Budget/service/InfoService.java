package joonseo.final_Budget.service;

import joonseo.final_Budget.domain.ExpenseCategory;
import joonseo.final_Budget.domain.Info;
import joonseo.final_Budget.persistance.DataRepository;

import java.time.LocalDate;
import java.util.List;

public class InfoService {
    private final DataRepository dataRepository;

    public InfoService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<Info> findAllExpense() {
        return dataRepository.selectAllInfo();
    }

    public Info findInfoByDate(LocalDate date){
        return dataRepository.selectInfoByDate(date);
    }

    public void registerInfo(Info info){
        dataRepository.insertInfo(info);
    }

    public List<Info> getAllExpenses() {
        return dataRepository.selectAllInfo();
    }
    public Info getExpenseByDate(LocalDate date) {
        return dataRepository.selectInfoByDate(date);
    }
    public void addExpense(LocalDate date, ExpenseCategory category, int amount, String description) {
        Info info = dataRepository.selectInfoByDate(date);

        if (info == null) {
            info = new Info(date, 0);
        }

        info.addExpense(category, amount, description);
        dataRepository.insertInfo(info);
    }




}
