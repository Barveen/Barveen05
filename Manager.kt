package file2


class Manager(
    employeeId: String,
    employeeName: String,
    role: String,
    salary: String,
    phoneNumber: String,
    eMailId: String
) : Employee2(employeeId, employeeName, role, salary, phoneNumber, eMailId) {

    override fun toString(): String {
        return """
             
             ID : $employeeId
             Name : $employeeName
             Role : $role
             Salary : $salary
             E-MailId : $eMailId
             Phone Number : $phoneNumber
             """.trimIndent()
    }
}