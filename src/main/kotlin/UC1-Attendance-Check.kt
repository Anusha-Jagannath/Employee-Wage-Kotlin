/*
* checking whether employee is present or absent
*/
fun main() {
    println("Welcome to Employee Wage Computation Program")
    //constants
    var IS_FULL_TIME = 1
    //computation
    var empCheck = (Math.floor(Math.random() * 10) % 2).toInt()
    if (empCheck == IS_FULL_TIME) {
        println("Employee is present")
    } else {
        println("Employee is absent")
    }
}