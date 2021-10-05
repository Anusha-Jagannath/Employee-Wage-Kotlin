/*
 * checking whether employee is present or absent and calculating daily wage for full time
 * and part time employee
 */
fun main() {
    println("Welcome to Employee Wage Computation Program")
    //constants
    val IS_FULL_TIME = 2
    val IS_PART_TIME = 1
    val EMP_RATE_PER_HOUR = 20
    var empHrs = 0
    var empWage = 0
    //computation
    var empCheck = (Math.floor(Math.random() * 10) % 3).toInt()
    if (empCheck == IS_FULL_TIME) {
        var emp = EmployeeType.FullTime()
        empHrs = getEmployeeHour(emp)
    } else if (empCheck == IS_PART_TIME) {
        var emp = EmployeeType.PartTime()
        empHrs = getEmployeeHour(emp)
    } else {
        var emp = EmployeeType.NotEmployee()
        empHrs = getEmployeeHour(emp)
    }
    empWage = empHrs * EMP_RATE_PER_HOUR;
    println("Employee wage : $empWage")
}

/**
 * getEmployeeHours method computes employee hours based on type of employee
 * @param employee which can be full time, part-time or not an employee
 * @return empHrs
 */
fun getEmployeeHour(employee: EmployeeType): Int {
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
