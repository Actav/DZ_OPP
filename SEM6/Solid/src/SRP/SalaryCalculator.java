package SRP;

public class SalaryCalculator {
    public int calculateNetSalary(Employee employee) {
        int baseSalary = employee.getBaseSalary();
        int tax = (int) (baseSalary * 0.25);
        return baseSalary - tax;
    }
}
