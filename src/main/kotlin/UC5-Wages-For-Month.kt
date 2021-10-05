/*
* checking whether employee is present or absent and calculating daily wage for full time
* and part time employee
*/

fun main() {
    println("Welcome to Employee Wage Computation Program")
    //constants
    val isFullTime = 2
    val isPartTime = 1
    val empRatePerHour = 20
    val noOFWorkingDays = 20
    var empHrs = 0
    var empWage = 0
    var totalWage = 0;
    // iterate till noOfWorkingDays and compute total wage
    for (i in 0 until noOFWorkingDays) {
        //computation
        var empCheck = (Math.floor(Math.random() * 10) % 3).toInt()

        // uc4 - refactoring using switch case
        when (empCheck) {
            isFullTime -> {
                var emp = EmployeeType.FullTime()
                empHrs = getEmployeeTime(emp)
            }
            isPartTime -> {
                var emp = EmployeeType.PartTime()
                empHrs = getEmployeeTime(emp)
            }
            else -> {
                var emp = EmployeeType.NotEmployee()
                empHrs = getEmployeeTime(emp)
            }
        }

        empWage = empHrs * empRatePerHour
        totalWage += empWage
        println("Employee wage : $empWage")
    }
    println("Total employee wage for a month $totalWage")
}

/*
 * getEmployeeHours method computes employee hours based on type of employee
 * @param employee which can be full time, part-time or not an employee
 * @return empHrs
 */
fun getEmployeeTimes(employee: EmployeeType): Int {
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
