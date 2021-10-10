/*
* checking whether employee is present or absent and calculating daily wage for full time
* and part time employee
* adding code for multiple companies and save total wage
* refactor code is done using list rather than array to store employee details
* use interface approach
* used ArrayList to store company details
* displaying daily wages for company
* query total wage by company name
*/

var map = hashMapOf<String, Int>()
fun main() {
    println("Welcome to Employee Wage Computation Program")
    val employee = EmployeeWagesBuilder()
    employee.addEmpCompany("Jio", 20, 20, 100);
    employee.addEmpCompany("Dmart", 20, 10, 100);
    employee.computeEmpWage()
    employee.getTotalWageByCompany("Dmart")
}

/**
 * EmployeeWagesBuilder implements CompanyInterface
 */
class EmployeeWagesBuilder : CompanyInterface {
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
            dailyWagesList.add(empWage)
            totalWage += empWage
            totalEmployeeHours += empHrs
            println("Employee wage : $empWage")
        }
        println("Daily wages of company is $dailyWagesList") //uc13 displaying daily wages
        printEmployeeWage(company, totalWage)
        map.put(company.companyName, totalWage)
    }

    /** uc14
     * method to  query total wage by company name
     * @param companyName
     */
    fun getTotalWageByCompany(companyName: String) {
        println("The total wage of $companyName is ${map.get(companyName)}")
    }
}

