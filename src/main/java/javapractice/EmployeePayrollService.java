package javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService() {}

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList){
        this.employeePayrollList = employeePayrollList;
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) {
        System.out.println("Enter id: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter Salary: ");
        Double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public long readEmployeePayrollData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            this.employeePayrollList = new EmployeePayrollFileIOService().readData();
        return employeePayrollList.size();
    }

    public void writeEmployeePayrollData(IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            employeePayrollList.stream().forEach(System.out::println);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().write(employeePayrollList);
    }

    public void printData(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
    }

    public long countEntries(IOService ioService) {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<EmployeePayrollData> employeePayrollDataArrayList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollDataArrayList);
        Scanner sc = new Scanner(System.in);
        employeePayrollService.readEmployeePayrollData(sc);
        employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
    }
}
