/**
 * CompanyInterface consists of abstract method
 */
interface CompanyInterface {
    fun addEmpCompany(companyName: String,wagePerHours: Int,noOfWorkingDays: Int,maxHourPerMonth: Int)
    fun computeEmpWage()
    fun wageForCompany(company: Company)
}