package problem2;

public interface PayrollSystemADT {
    Boolean checkEmpty();
    Integer countNumberOfEmployees();

    PayrollSystemADT addEmployee(Employee employee);

    PayrollSystemADT removeEmployee(Employee employee) throws EmployeeNotFountException;
    Boolean checkSpecifiedEmployee(Employee employee);
    PayrollSystemADT findAndGetEmployeesWithAnnualEarningsOver150k();
    PayrollSystemADT findAndGetEmployeesWithSameRole(String currentRole);
    PayrollSystemADT findAndGetEmployeesWithSameJoinedYear(Integer year);

}
