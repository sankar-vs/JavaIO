package javapractice;

public class EmployeePayrollData {
    String id;
    String name;
    String salary;

    public EmployeePayrollData(String id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id +"  Name: " + name + "  Salary: " + salary;
    }
}
