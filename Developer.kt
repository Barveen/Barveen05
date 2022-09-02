package file2

class Developer(
    employeeId: String,
    employeeName: String,
    role: String,
    var position: String?,
    salary: String,
    phoneNumber: String,
    eMailId: String,
    var reportingId: String?
) : Employee2(employeeId, employeeName, role, salary, phoneNumber, eMailId) {




    override fun toString(): String {
        return """
             
             ID : $employeeId
             Name : $employeeName
             Role : $role
             Reporting Manager: $reportingId
             Salary : $salary
             E-MailId : $eMailId
             """.trimIndent()
    }
}