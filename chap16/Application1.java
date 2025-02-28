package joonseo.chap16;
import java.util.*;
import java.util.stream.Collectors;

public class Application1 {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("홍길동", 25, "IT", 6000),
                new Employee("김철수", 28, "HR", 3000),
                new Employee("이영희", 30, "IT", 7000),
                new Employee("박민수", 22, "영업", 4000),
                new Employee("최지현", 35, "HR", 3500),
                new Employee("한석봉", 40, "IT", 5000)
        );

        // 1. 모든 직원의 이름을 쉼표로 구분된 문자열로 반환
        String allNames = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));

        List<String> highSalaryIT = employees.stream()
                .filter(e -> e.getDepartment().equals("IT") && e.getSalary() >= 5000) // IT 부서 & 급여 5000 이상 필터링
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // 급여 기준 내림차순 정렬
                .map(Employee::getName) // 이름만 추출
                .collect(Collectors.toList()); // 리스트로 변환

        // 3. 각 부서별 평균 급여를 계산하여 맵으로 반환
        Map<String, Double> averageSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,                // 부서별 그룹화
                        Collectors.averagingInt(Employee::getSalary) // 평균 급여 계산
                ));

                System.out.println(allNames); // 출력 예시: "홍길동, 김철수, 이영희, 박민수, 최지현, 한석봉"
        System.out.println(highSalaryIT); // 출력 예시: [이영희, 홍길동, 한석봉]
        System.out.println(averageSalaryByDept); // 출력 예시: {HR=3250.0, IT=6000.0, 영업=4000.0}
    }
}

