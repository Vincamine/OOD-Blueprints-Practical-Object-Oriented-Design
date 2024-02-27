package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PayrollSystemTest {
    Employee employee1,employee2,employee3,employee4,employee2ChangeRole;
    PayrollSystem payrollSystemEmpty,payrollSystemNormal,payrollSystemTest;

    @BeforeEach
    void setUp() {
        employee1 = new Employee("Pumpkin","Vegetable",120000.00F,"level1", 2000);
        employee2 = new Employee("Potato","Vegetable",100000.00F,"level1",2020);
        employee2ChangeRole = new Employee("Potato","Vegetable",100000.00F,"level2",2020);
        employee3 = new Employee("Apple","Fruit",200000.00F,"level3",2022);
        employee4 = new Employee("Banana","Fruit",250000.00F,"level4", 2000);
        payrollSystemEmpty = new PayrollSystem(null,null);
        payrollSystemNormal = new PayrollSystem(employee1,null);
        payrollSystemTest = new PayrollSystem(employee2,payrollSystemNormal);
    }

    @Test
    void checkEmpty() {
        assertTrue(payrollSystemEmpty.checkEmpty());
        assertFalse(payrollSystemNormal.checkEmpty());
    }

    @Test
    void countNumberOfEmployees() {
        assertEquals(0, (int) payrollSystemEmpty.countNumberOfEmployees());
        assertEquals(1, (int) payrollSystemNormal.countNumberOfEmployees());
        payrollSystemEmpty = (PayrollSystem) payrollSystemEmpty.addEmployee(employee1);
        assertEquals(1, (int) payrollSystemEmpty.countNumberOfEmployees());
        payrollSystemEmpty = (PayrollSystem) payrollSystemEmpty.addEmployee(employee2);
        assertEquals(2, (int) payrollSystemEmpty.countNumberOfEmployees());
        payrollSystemTest = (PayrollSystem) payrollSystemTest.addEmployee(employee4);
        assertEquals( 3, (int) payrollSystemTest.countNumberOfEmployees());

    }

    @Test
    void addEmployee() {
        payrollSystemTest = (PayrollSystem) payrollSystemTest.addEmployee(employee2ChangeRole);
        assertFalse(payrollSystemNormal.checkSpecifiedEmployee(employee2));
        assertTrue(payrollSystemTest.checkSpecifiedEmployee(employee2ChangeRole));

    }

    @Test
    void removeEmployee() throws EmployeeNotFountException {
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee2);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee3);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee4);
        assertTrue(payrollSystemNormal.checkSpecifiedEmployee(employee4));
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.removeEmployee(employee4);
        assertFalse(payrollSystemNormal.checkSpecifiedEmployee(employee4));
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.removeEmployee(employee1);
        assertFalse(payrollSystemNormal.checkSpecifiedEmployee(employee1));
    }

    @Test
    void checkSpecifiedEmployee() {
        assertFalse(payrollSystemEmpty.checkSpecifiedEmployee(employee3));
        assertFalse(payrollSystemEmpty.checkSpecifiedEmployee(employee2));
    }

    @Test
    void findAndGetEmployeesWithAnnualEarningsOver150k() {
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee4);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee3);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee2);

        PayrollSystem payrollSystem = (PayrollSystem) payrollSystemNormal.findAndGetEmployeesWithAnnualEarningsOver150k();
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee3));
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee4));
        assertFalse(payrollSystem.checkSpecifiedEmployee(employee1));
        assertFalse(payrollSystem.checkSpecifiedEmployee(employee2));



    }

    @Test
    void findAndGetEmployeesWithSameRole() {
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee4);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee3);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee2);
        PayrollSystem payrollSystem = (PayrollSystem) payrollSystemNormal.findAndGetEmployeesWithSameRole("level1");
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee1));
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee2));
        assertFalse(payrollSystem.checkSpecifiedEmployee(employee3));

    }

    @Test
    void findAndGetEmployeesWithSameJoinedYear() {
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee4);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee3);
        payrollSystemNormal = (PayrollSystem) payrollSystemNormal.addEmployee(employee2);
        PayrollSystem payrollSystem = (PayrollSystem) payrollSystemNormal.findAndGetEmployeesWithSameJoinedYear(2000);
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee1));
        assertTrue(payrollSystem.checkSpecifiedEmployee(employee4));
        assertFalse(payrollSystem.checkSpecifiedEmployee(employee2));
    }
}