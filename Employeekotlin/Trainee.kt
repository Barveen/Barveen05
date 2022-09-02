package file2



class Trainee(
    employeeId: String,
    employeeName: String,
    role: String,
    salary: String,
    phoneNumber: String,
    eMailId: String,
    var position: String,
    var mentorMailId: String?
) : Employee2(employeeId, employeeName, role, salary, phoneNumber, eMailId) {
    /*var position : String? = position
    var mentorMailId : String? = null*/
    override fun toString(): String {
        return """
              
              ID : $employeeId
              Name : $employeeName
              Role : $role
              Position: $position
              Salary : $salary
              MentorMailId: $mentorMailId
              E-MailId : $eMailId
              PhoneNumber : $phoneNumber
              """.trimIndent()
    }


}
