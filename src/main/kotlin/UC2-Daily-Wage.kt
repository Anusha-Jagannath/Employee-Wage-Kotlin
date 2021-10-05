/*
* checking whether employee is present or absent and calculating daily wage for full time and part time employee
*/
fun main() {
    println("Welcome to Employee Wage Computation Program")
    //constants
    val IS_FULL_TIME = 1
    val EMP_RATE_PER_HOUR = 20
    var empHrs = 0
    var empWage = 0
    //computation
    var empCheck = (Math.floor(Math.random() * 10) % 2).toInt()
    if (empCheck == IS_FULL_TIME) {
        var emp = EmployeeType.FullTime()
        empHrs = getEmployeeHours(emp)
    }
    else {
        var emp = EmployeeType.NotEmployee()
        empHrs = getEmployeeHours(emp)
    }
    empWage = empHrs * EMP_RATE_PER_HOUR;
    println("Employee wage : $empWage")
}

/**
 * getEmployeeHours method computes employee hours based on type of employee
 * @param employee
 * @return empHrs
 */
fun getEmployeeHours(employee: EmployeeType): Int {
    var empHrs = 0
    when (employee) {
        is EmployeeType.FullTime -> {
            println("Employee is present")
            empHrs = 8
        }
        is EmployeeType.NotEmployee -> {
            println("Employee is absent")
            empHrs = 0
        }
    }
    return empHrs
}
