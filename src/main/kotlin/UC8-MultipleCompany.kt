/*
* checking whether employee is present or absent and calculating daily wage for full time
* and part time employee
* adding code for multiple companies
*/
var noOfCompanies = 0
var companies = mutableListOf<Company>()
fun main() {
    println("Welcome to Employee Wage Computation Program")
    addCompany("Jio", 20, 20, 100);
    addCompany("Dmart", 20, 10, 100);
    computeWage()
}

/**
 * method to add company to the list
 */
fun addCompany(name: String, empWagePerHrs: Int, noOfWorkingDays: Int, maxHrsPerMonth: Int) {
    var company = Company(name, empWagePerHrs, noOfWorkingDays, maxHrsPerMonth)
    companies.add(company)
    noOfCompanies++
}

/**
 * method to compute wage for a company
 */
fun computeWageForCompany(company: Company) {
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
                empHrs = getEmployeeWageHours(emp)
            }
            isPartTime -> {
                var emp = EmployeeType.PartTime()
                empHrs = getEmployeeWageHours(emp)
            }
            else -> {
                var emp = EmployeeType.NotEmployee()
                empHrs = getEmployeeWageHours(emp)
            }
        }

        empWage = empHrs * company.empWagePerHour
        totalWage += empWage
        totalEmployeeHours += empHrs
        println("Employee wage : $empWage")
    }
    println("Company name : ${company.companyName}")
    println("Total employee wage for a month $totalWage")
}

/**
 * method to invoke compute wage for each company
 */
fun computeWage() {
    for (company in companies) {
        computeWageForCompany(company)
    }
}

/*
 * getEmployeeWorkingHours method computes employee hours based on type of employee
 * @param employee which can be full time, part-time or not an employee
 * @return empHrs
 */
fun getEmployeeWorkingHrs(employee: EmployeeType): Int {
    var empHrs = 0
    when (employee) {
        is EmployeeType.FullTime -> {
            println("Employee is full time")
            empHrs = 8
        }
        is EmployeeType.PartTime -> {
            println("Employee is part time")
            empHrs = 4
        }
        is EmployeeType.NotEmployee -> {
            println("Employee is absent")
            empHrs = 0
        }
    }
    return empHrs
}
