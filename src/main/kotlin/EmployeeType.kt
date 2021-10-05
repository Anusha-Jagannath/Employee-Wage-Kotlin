/*
 * EmployeeType is a sealed class which consists of FullTime ,PartTime, NotEmployee class
 */
sealed class EmployeeType {
    class FullTime() : EmployeeType()
    class PartTime() : EmployeeType()
    class NotEmployee() : EmployeeType()
}