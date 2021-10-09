/*
* checking whether employee is present or absent and calculating daily wage for full time
* and part time employee
* adding code for multiple companies and save total wage
* refactor code is done using list rather than array to store employee details
* use interface approach
* used ArrayList to store company details
*/

fun main() {
    println("Welcome to Employee Wage Computation Program")
    val employee = EmployeeBuilder()
    employee.addEmpCompany("Jio", 20, 20, 100);
    employee.addEmpCompany("Dmart", 20, 10, 100);
    employee.computeEmpWage()
}

class EmployeeBuilder : CompanyInterface {
    /**
     * method to add company details to list
     * @param companyName, wagePerHours, noOfWorkingDays, maxHourPerMonth
     */
    override fun addEmpCompany(companyName: String, wagePerHours: Int, noOfWorkingDays: Int, maxHourPerMonth: Int) {
        var company = Company(companyName, wagePerHours, noOfWorkingDays, maxHourPerMonth)
        companies.add(company)
        noOfCompanies++
    }

    /**
     * method to compute wage for each company
     */
    override fun computeEmpWage() {
        for (company in companies) {
            wageForCompany(company)
        }
    }

    /**
     * implementing compute wage functionality
     * @param company
     */
    override fun wageForCompany(company: Company) {
        //constants
        val isFullTime = 2
        val isPartTime = 1
        var empHrs = 0
        var empWage = 0
        var totalWage = 0
        var totalEmployeeHours = 0
        var totalWorkingDays = 0
        // iterate till noOfWorkingDays and compute total wage
        while (totalEmployeeHours <= company.maxHoursPerMonth && totalWorkingDays < company.noOfWorkingDays) {
            totalWorkingDays++
            //computation
            var empCheck = (Math.floor(Math.random() * 10) % 3).toInt()
            // uc4 - refactoring using switch case
            when (empCheck) {
                isFullTime -> {
                    var emp = EmployeeType.FullTime()
                    empHrs = getEmployeeHoursForWork(emp)
                }
                isPartTime -> {
                    var emp = EmployeeType.PartTime()
                    empHrs = getEmployeeHoursForWork(emp)
                }
                else -> {
                    var emp = EmployeeType.NotEmployee()
                    empHrs = getEmployeeHoursForWork(emp)
                }
            }
            empWage = empHrs * company.empWagePerHour
            totalWage += empWage
            totalEmployeeHours += empHrs
            println("Employee wage : $empWage")
        }
        printEmployeeWage(company, totalWage)
    }
}

