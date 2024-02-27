package problem2;


import java.util.Objects;

public class PayrollSystem implements PayrollSystemADT {
    protected Employee fisrtEmployee;
    protected PayrollSystem restEmployees;


    public PayrollSystem(Employee fisrtEmployee, PayrollSystem restEmployees) {
        this.fisrtEmployee = fisrtEmployee;
        this.restEmployees = restEmployees;
    }
    public PayrollSystem(Employee fisrtEmployee) {
        this.fisrtEmployee = fisrtEmployee;
        this.restEmployees = null;
    }



    /**
     * @param
     * @return
     */
    @Override
    public Boolean checkEmpty() {
        if(this.fisrtEmployee == null){return Boolean.TRUE;}
        return Boolean.FALSE;
    }

    /**
     * @param
     * @return
     */
    @Override
    public Integer countNumberOfEmployees() {
        if(this.fisrtEmployee == null){return  0;
        } else if (this.restEmployees == null) {
            return 1;
        } else {
            return this.restEmployees.countNumberOfEmployees() + 1;
        }
    }


    /**
     * @return
     */
    @Override
    public PayrollSystemADT addEmployee(Employee employee) {
        if(this.fisrtEmployee == null){
            return new PayrollSystem(employee,null);
        } else if(! checkSpecifiedEmployee(employee)){
            return new PayrollSystem(employee, this);
        } else {
            return this.changeRole(employee);
        }

    }

    public PayrollSystem changeRole(Employee employee){
        if(!this.fisrtEmployee.equals(employee)){
            return new PayrollSystem(fisrtEmployee, restEmployees.changeRole(employee));
        }
            this.fisrtEmployee.currentRole = employee.currentRole;
            return new PayrollSystem(this.fisrtEmployee,this.restEmployees);
    }

    /**
     * @return
     */
    @Override
    //xxx() throws RuntimeException; T: catch(throw Exception). F: catch(throw IllegalArgumentException)
    public PayrollSystemADT removeEmployee(Employee employee) throws EmployeeNotFountException{
        if(!checkSpecifiedEmployee(employee)) throw new EmployeeNotFountException("Employee not found!");
        if(this.fisrtEmployee.equals(employee)){
            return this.restEmployees;
        }
        return new PayrollSystem(fisrtEmployee,
            (PayrollSystem) this.restEmployees.removeEmployee(employee));
    }

    /**
     * @return
     */
    @Override
    public Boolean checkSpecifiedEmployee(Employee employee) {
        if(this.fisrtEmployee == null){
            return false;
        } else {
            if(this.fisrtEmployee.equals(employee)){return true;}
            else {
                if (this.restEmployees != null) {
                    return this.restEmployees.checkSpecifiedEmployee(employee);
                } else {
                    return false;
                }
            }
        }
    }

    /**
     * @return
     */
    @Override
    public PayrollSystemADT findAndGetEmployeesWithAnnualEarningsOver150k() {
        if(this.checkEmpty()){
            return null;
        } else {
//            PayrollSystem payrollSystemWithSameRole = new PayrollSystem(null, null);
            if (this.fisrtEmployee.annualEarning.compareTo(150000.00F) > 0) {
                return new PayrollSystem(this.fisrtEmployee, (PayrollSystem) this.restEmployees.findAndGetEmployeesWithAnnualEarningsOver150k());
//                payrollSystemWithSameRole.addEmployee(this.fisrtEmployee);
            } else {
                if(this.restEmployees == null){
                    return null;
                }
                return this.restEmployees.findAndGetEmployeesWithAnnualEarningsOver150k();
            }
            //this.restEmployees.findAndGetEmployeesWithAnnualEarningsOver150k();  //F new every time
            //payrollSystemWithSameRole.addEmployee(this.fisrtEmployee.)
            //return payrollSystemWithSameRole;
        }
    }

    /**
     * @param currentRole
     * @return
     */
    @Override
    public PayrollSystemADT findAndGetEmployeesWithSameRole(String currentRole) {
        if(this.checkEmpty()){ return null;}
        if(this.fisrtEmployee.currentRole.equals(currentRole)){
            if(this.restEmployees == null){
                return new PayrollSystem(this.fisrtEmployee,null);
            }
            return new PayrollSystem(this.fisrtEmployee, (PayrollSystem) this.restEmployees.findAndGetEmployeesWithSameRole(currentRole));
        } else {
            if (this.restEmployees == null) {
                return null;
            }
            return this.restEmployees.findAndGetEmployeesWithSameRole(currentRole);
        }
    }

    /**
     * @param year
     * @return
     */
    @Override
    public PayrollSystemADT findAndGetEmployeesWithSameJoinedYear(Integer year) {
        if(this.checkEmpty()){ return null;}
        if(this.fisrtEmployee.yearOfJoin.equals(year)){
            if(this.restEmployees == null){
                return new PayrollSystem(this.fisrtEmployee, null);
            }
            return new PayrollSystem(this.fisrtEmployee, (PayrollSystem) this.restEmployees.findAndGetEmployeesWithSameJoinedYear(year));
        } else {
            if(this.restEmployees == null){ return null;}
            return this.restEmployees.findAndGetEmployeesWithSameJoinedYear(year);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PayrollSystem that)) {
            return false;
        }
        return Objects.equals(fisrtEmployee, that.fisrtEmployee) && Objects.equals(
            restEmployees, that.restEmployees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fisrtEmployee, restEmployees);
    }

    @Override
    public String toString() {
        return "PayrollSystem{" +
            "fisrtEmployee=" + fisrtEmployee +
            ", restEmployees=" + restEmployees +
            '}';
    }
}
