/**
 * data class Company has company details like name,wage per hour,no of working days, max hour per month
 */
data class Company(
    var companyName: String,
    var empWagePerHour: Int,
    var noOfWorkingDays: Int,
    var maxHoursPerMonth: Int
) {

}
