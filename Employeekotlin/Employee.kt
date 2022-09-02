package file2

open class Employee2(
    var employeeId: String,
    var employeeName: String,
    var role: String,
    var salary: String,
    var phoneNumber: String,
    var eMailId: String
) {


    override fun toString(): String {
        return """
              
              ID : $employeeId
              Name : $employeeName
              Role : $role
              Salary : $salary
              E-MailId : $eMailId
              PhoneNumber : $phoneNumber
              """.trimIndent()
    }

    /*fun getMailId(): String? {
        return eMailId
    }
    fun getEmployeeId(): String? {
        return employeeId
    }

     fun getEmployeeName(): String? {
        return employeeName
    }

    open fun getSalary(): Double {
        return salary
    }

    open fun getRole(): String? {
        return role
    }

    fun getPhoneNumber(): String? {
        return phoneNumber
    }
*/

}