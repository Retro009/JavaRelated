package StreamsAndLambda;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String args[]){
        //Stream<Integer> stream = Stream.of(1,2,3,4,5,6);
        //System.out.println(getOdd(stream));
        //below method cant run as stream is closed after above method getOdd;
        //System.out.println(getFirstNumber(stream));

        //Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
        //System.out.println("Total Sum is: "+getSum(stream2));

        List<Employee> list = Arrays.asList(
                new Employee("John Doe", 70000, "IT", LocalDate.of(2019, 3, 15)),
                new Employee("Jane Smith", 82000, "HR", LocalDate.of(2018, 6, 1)),
                new Employee("Mike Johnson", 75000, "IT", LocalDate.of(2020, 2, 10)),
                new Employee("Emily Brown", 69000, "Marketing", LocalDate.of(2021, 8, 20)),
                new Employee("David Lee", 88000, "IT", LocalDate.of(2017, 11, 5)),
                new Employee("Sarah Wilson", 72000, "HR", LocalDate.of(2022, 1, 15)),
                new Employee("Tom Taylor", 77000, "Marketing", LocalDate.of(2020, 5, 1)),
                new Employee("Lisa Anderson", 91000, "IT", LocalDate.of(2016, 4, 12)),
                new Employee("Robert Martin", 68000, "HR", LocalDate.of(2022, 9, 1)),
                new Employee("Emma Garcia", 79000, "Marketing", LocalDate.of(2019, 7, 8))
        );
        //Find The Avg Salary of all the Employee
        double avgSalary = list.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println("Average Salary: "+avgSalary);

        // 2. Top 3 highest-paid employees
        List<String> topPaidEmployees = list.stream().sorted((emp1,emp2) -> Double.compare(emp2.getSalary(),emp1.getSalary())).limit(3).map(Employee::getName).collect(Collectors.toList());// Your code here
        System.out.println("Top 3 highest-paid employees: " + topPaidEmployees);

        // 3. Average salary by department
        Map<String, Double> avgSalaryByDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary))); // Your code here
        System.out.println("Average salary by department: " + avgSalaryByDept);

        // 4. Highest-paid employee in each department
        Map<String, Optional<Employee>> highestPaidByDept = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy((emp1,emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))));// Your code here
        highestPaidByDept.forEach((dept, emp) ->
                        System.out.println(dept + ": " + emp.map(Employee::getName).orElse("N/A")));

        // 5. Total salary for employees hired in the last 3 years
        LocalDate threeYearsAgo = LocalDate.now().minusYears(3);
        double recentHiresSalary = list.stream().filter(employee -> employee.getHiringDate().isAfter(threeYearsAgo)).reduce(0.0, (totalSum, employee) -> totalSum + employee.getSalary(), Double::sum);// Your code here
        System.out.println("Total salary for recent hires: " + recentHiresSalary);
    }

    static Optional<Integer> getFirstNumber(Stream<Integer> stream){
        return stream.filter(x -> x%2 == 0).findFirst();
    }
    static List<Integer> getOdd(Stream<Integer> stream){
        List<Integer> collect = stream.filter(i -> i % 2 != 0).collect(Collectors.toList());
        return collect;
    }

    static int getSum(Stream<Integer> stream){
        Integer reduce = stream.reduce(0, ((sum, i) -> sum + i));
        return reduce;
    }
}
