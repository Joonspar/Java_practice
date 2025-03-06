package joonseo.final_Budget.ui;

import joonseo.final_Budget.domain.ExpenseCategory;
import joonseo.final_Budget.domain.Info;
import joonseo.final_Budget.persistance.DataRepository;
import joonseo.final_Budget.persistance.FileDataStorage;
import joonseo.final_Budget.service.InfoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Application {
    private  InfoService infoService;
    private  Scanner sc;
    public static void main(String[] args) {
        new Application().run();
    }
    public Application(){
        DataRepository dataRepository = new DataRepository(new FileDataStorage());
        this.infoService = new InfoService(dataRepository);
        this.sc = new Scanner(System.in);
    }

    public void run(){

        while(true){
            System.out.println("==== 무엇을 하고싶으시죠? ==== ");
            System.out.println("1. 총 지출 확인");
            System.out.println("2. 날짜별 지출 확인");
            System.out.println("3. 가계부 등록");
            System.out.println("9. 종료");
            System.out.print("번호 선택 : ");
            int num = sc.nextInt();
            sc.nextLine();

            try{
                switch (num){
                    case 1 -> showAllExpends();
                    case 2 -> showByDate();
                    case 3 -> registerExpend();
                    case 9 -> {
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다.");
                }
            }catch (Exception e){
                System.out.println("오류 : " + e.getMessage());
            }
        }
    }

    public void showAllExpends() {
        List<Info> allExpenses = infoService.getAllExpenses();
        if (allExpenses.isEmpty()) {
            System.out.println("지출 내역이 없습니다.");
            return;
        }

        int total = 0;
        System.out.println("==== 전체 지출 내역 ====");
        for (Info info : allExpenses) {
            System.out.println(info);
            total += info.getTotalExpend();
        }
        System.out.println("총 지출 합계: " + total + "원");
    }

    public void showByDate() {
        System.out.print("원하는 날짜 입력 : ");
        String inputDate = sc.nextLine();

        try {
            LocalDate date = LocalDate.parse(inputDate);
            Info info = infoService.getExpenseByDate(date);

            if (info == null) {
                System.out.println("해당 날짜의 지출 내역이 없습니다.");
            } else {
                System.out.println(info);
            }
        } catch (Exception e) {
            System.out.println("잘못된 날짜 형식입니다.");
        }
    }

    public void registerExpend() {
        System.out.print("지출 날짜 입력 (yyyy-MM-dd): ");
        String inputDate = sc.nextLine();

        try {
            LocalDate date = LocalDate.parse(inputDate);

            System.out.println("지출 카테고리를 선택하세요:");
            for (ExpenseCategory category : ExpenseCategory.values()) {
                System.out.println((category.ordinal() + 1) + ". " + category);
            }

            System.out.print("카테고리 번호 입력: ");
            String categoryStr = sc.nextLine();
            int categoryIndex = Integer.parseInt(categoryStr);

            if (categoryIndex < 1 || categoryIndex > ExpenseCategory.values().length) {
                System.out.println("올바른 카테고리를 선택하세요.");
                return;
            }

            ExpenseCategory selectedCategory = ExpenseCategory.values()[categoryIndex - 1];

            System.out.print("지출 금액 입력: ");
            String amountStr = sc.nextLine();
            int amount = Integer.parseInt(amountStr);

            System.out.print("상세 내용 입력: ");
            String description = sc.nextLine();

            System.out.println("입력한 데이터 확인:");
            System.out.println("날짜: " + date);
            System.out.println("카테고리: " + selectedCategory);
            System.out.println("금액: " + amount);
            System.out.println("상세 내용: " + description);

            infoService.addExpense(date, selectedCategory, amount, description);
            System.out.println("지출이 성공적으로 등록되었습니다.");

        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            e.printStackTrace();
        }
    }




}
