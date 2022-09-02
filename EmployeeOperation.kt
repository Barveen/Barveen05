package file2
import java.util.*

class EmployeeOperation {
    private var found : Boolean = false
    var role: String = ""
    var salary : String = ""
    private var phoneNumber: String = ""
    var mailId: String = ""
    var i = 0
    var s = Scanner(System.`in`)
    private val s1 = Scanner(System.`in`)
    private var empNo: String = ""
    private var empName: String = ""
    var position: String = ""
    var reportingId: String = ""
    private val employeeConnect = EmployeeConnect()
    private val userInput = UserInput()


    private fun insertEmployeeDetails()
    {
        print("Enter the Employee number :")
        empNo = userInput.inputId()
        print("Enter the Employee name :")
        empName = userInput.inputName()
        print("Enter the Phone number : ")
        phoneNumber = userInput.inputPhoneNumber()
        print("Enter the mailId : ")
        mailId = userInput.inputMailId()

    }
    fun insertTrainee()
    {
        insertEmployeeDetails()
        print("Enter the Employee Salary :")
        salary = userInput.inputInteger("Trainee").toString()
        position = "Trainee"
        println("Choose the trainees Role : " +
                "\n 1 For Incubation Trainee" +
                "\n 2 For Project Trainee")
        when(s1.nextInt()){
            1 -> role = "Incubation Trainee"
            2 -> role = "Project Trainee"
        }
        getMentorMailId()
        reportingId = if(found) {
            println("Enter the ReportingId listed above: ")
            s1.next()
        }else{
            "null"
        }
        val trainee= Trainee(empNo, empName, role, salary, phoneNumber, mailId, position, reportingId) // Employee
        found = (employeeConnect as EmployeeInterface).insertTrainee(trainee)
        if(found)
        {
            println("Trainee Record Added Successfully")
        }

    }

    fun insertDeveloper()
    {
        insertEmployeeDetails()
        print("Enter the Employee Salary :")
        salary = userInput.inputInteger("Developer").toString()
        position = "Developer"
        println("Enter your choice :\n 1 for Developer\n 2 for Mentor")
        val choice = s1.nextInt()
        if (choice == 1) {
            role = "Developer"
        } else if (choice == 2) {
            role = "Mentor"
        }
        getManagerMailId()
        reportingId = if(found) {
            println("Enter the ReportingId listed above: ")
            s1.next()
        }else{
            "null"
        }
        val developer = Developer(empNo, empName, role, position, salary, phoneNumber, mailId, reportingId)
        found = (employeeConnect as EmployeeInterface).insertDeveloper(developer)
        if(found)
        {
            println("Developer Added Successfully")
        }

    }

    fun insertManager()
    {
        insertEmployeeDetails()
        print("Enter the Employee Salary :")
        salary = userInput.inputInteger("Manager").toString()
        role = "Manager"
        val manager = Manager(empNo, empName, role, salary, phoneNumber, mailId)
        found = (employeeConnect as EmployeeInterface).insertManager(manager)
        if(found)
        {
            println("Manager Added Successfully")
        }
    }

    private fun getManagerMailId() {
        val j = 0
        val count  = 2
        val name = "Manager"
        val arr: Array<String>? = (employeeConnect as EmployeeInterface).getManagerMailId(count,name)
        if (arr != null) {
                for (mailId in arr) {
                    println("Managers mailId : ${j + 1}) $mailId")
                    found = true
                }
            } else {
                println("Managers are not available")
            found = false
        }

    }

    private fun getMentorMailId() {
        val j = 0
        val count  = 2
        val name = "Mentor"
        val arr: Array<String>? = (employeeConnect as EmployeeInterface).getMentorMailId(count,name)
        if (arr != null) {
                for (mailId in arr)
                {
                    println("Mentors mailId : ${j+1}) $mailId")
                    found = true
                }
            }else{
                println("Mentors are not available")
            found = false
        }
    }

    fun showAllEmployee()
    {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).showEmployee()
        if(emp.isNotEmpty())
        {
            for (i in emp)
            {
                println(i)
            }
        }else
        {
            println("Record not found")
        }
    }
    fun employeeWithNoMentors() {
        var j = 1
        val emp: MutableList<Employee2> = (employeeConnect as EmployeeInterface).employeeWithNoMentors()
        if (emp.isNotEmpty()) {
            for (name in emp) {
                println("Developers names : ${j}) ${name.employeeName}")
                j++
            }
        }else{
            println("No employee available")
        }
    }

    fun employeeWithNoManagers()
    {
        var j = 1
        val emp: MutableList<Employee2> = (employeeConnect as EmployeeInterface).employeeWithNoManagers()
        if (emp.isNotEmpty()) {
                for (name in emp) {
                    println("Developers names : ${j }) ${name.employeeName}")
                    j++
                }
        }else{
            println("No employee available")
        }
    }

    fun deleteEmployee() {
        println("Enter the employee Id you want to delete : ")
        empNo = s.next()
        found = (employeeConnect as EmployeeInterface).deleteEmployee(empNo)
        if(found)
        {
            println("Employee Record Deleted Successfully")
        }
        else {
            println("Record not found")
        }
    }


    fun updateEmployeeRecord()
    {
        println("Enter the Employee number that you want to update : ")
        empNo = userInput.inputId()
        println("Enter the field that ypu want to update" +
                "\n1 for Name" +
                "\n2 for Salary" +
                "\n3 for MailId" +
                "\n4 for Phone Number")
        when(s.nextInt()) {
            1 -> {
                println("Enter the name :")
                empName = userInput.inputName()
                found = (employeeConnect as EmployeeInterface).updateEmployeeRecord(1,empNo,empName)
            }
            2 -> {
                println("Enter the role of the employee :")
                role = readLine().toString()
                println("Enter the Salary :")
                salary = userInput.inputInteger(role).toString()
                found = (employeeConnect as EmployeeInterface).updateEmployeeRecord(2,empNo, salary)
            }
                3 ->{ println("Enter the name :")
                mailId = userInput.inputMailId()
                    found = (employeeConnect as EmployeeInterface).updateEmployeeRecord(3,empNo,mailId)
                }
            4 ->{ println("Enter the name :")
                phoneNumber = userInput.inputPhoneNumber()
                found = (employeeConnect as EmployeeInterface).updateEmployeeRecord(4,empNo,phoneNumber)
            }
            else -> {
                println("Enter the correct choice")
                updateEmployeeRecord()
            }
        }

    }
    fun searchByEmployeeId()
    {
        println("Enter the Employee id to Search : ")
        empNo = readLine().toString()
        val employee2 : Employee2? = (employeeConnect as EmployeeInterface).searchByEmployeeId(empNo)
        if(employee2 != null) {
            println(employee2)
        }else{
            println("Record not found")
        }
    }

    fun searchByEmployeeName()
    {
        println("Enter the Employee id to Search : ")
        empName = readLine().toString()
        val employee2 : Employee2? = (employeeConnect as EmployeeInterface).searchByEmployeeName(empName)
        if(employee2 != null) {
            println(employee2)
        }else{
            println("Record not found")
        }
    }

    fun searchByEmployeePosition() {
        println("Enter the Employee Position to Search : ")
        position = readLine().toString()
        val emp: MutableList<Employee2> = (employeeConnect as EmployeeInterface).searchByEmployeePosition(position)
        if(emp.isNotEmpty())
        {
            for (i in emp)
            {
                println(i)
            }
        }else
        {
            println("Record not found")
        }

    }

    fun searchByEmployeeRole() {
        println("Enter the Employee Role to Search : ")
        role = readLine().toString()
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).searchByEmployeeRole(role)
        for(i in emp)
        {
            println(i)
        }
    }

    fun showManager() {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).showManager()
        if(emp.isNotEmpty()) {
            for (i in emp) {
                println(i)
            }
        }else
        {
            println("Record not found")
        }
    }

    fun showMentors() {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).showMentors()
        if(emp.isNotEmpty()) {
            for (i in emp) {
                println(i.employeeName)
            }
        }else
        {
            println("Record not found")
        }
    }

    fun showTrainees() {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).showTrainees()
        if(emp.isNotEmpty()) {
            for (i in emp) {
                println(i)
            }
        }else
        {
            println("Record not found")
        }
    }

    fun assignMentorsToTrainee()
    {
        employeeWithNoMentors()
        println("Enter the trainee name want to assign mentor(trainees listed above):")
        val traineeName = readLine().toString()
        showMentors()
        println("Enter the mentor name in the above list for assign Trainee :")
        empName = readLine().toString()
        found = (employeeConnect as EmployeeInterface).assignMentorsToTrainee(traineeName,empName)
        if(found)
        {
            println("Mentor Assigned Successfully")
        }
    }

    fun assignManagers()
    {
        employeeWithNoManagers()
        println("Enter the employee name want to assign mentor(trainees listed above):")
        val employeeName = readLine().toString()
        showManager()
        println("Enter the mentor name in the above list for assign Trainee :")
        empName = readLine().toString()
        found = (employeeConnect as EmployeeInterface).assignManager(employeeName,empName)
        if(found)
        {
            println("Manager Assigned Successfully")
        }

    }

    fun sortBySalary()
    {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).sortBySalary()
        for (i in emp)
        {
            println(emp)
        }
     }

    fun sortByEmployeeId()
    {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).sortByEmployeeId()
        for (i in emp)
        {
            println(emp)
        }
    }

    fun sortByEmployeeName()
    {
        val emp : MutableList<Employee2> = (employeeConnect as EmployeeInterface).sortByEmployeeName()
        for (i in emp)
        {
            println(emp)
        }
    }
}


/*print("Enter the Employee position : ")
       position = s1.next()
       if (position.equals("Trainee", ignoreCase = true)) {
           val choice = s1.nextInt()
           if (choice == 1) {
               role = "Incubation Trainee"
           } else if (choice == 2) {
               role = "Project Trainee"
           }
          getMentorMailId()
           reportingId = if(found) {
               println("Enter the ReportingId listed above: ")
               s1.next()
           }else{
               println("Mentors not available")
               "null"
           }
           val trainee= Trainee(empNo, empName, role, salary, phoneNumber, mailId, position, reportingId) // Employee
           emp.add(trainee)
       } else if (position.equals("Developer", ignoreCase = true)) {
           println("Enter your choice :\n 1 for Developer\n 2 for Mentor")
           val choice = s1.nextInt()
           if (choice == 1) {
               role = "Developer"
           } else if (choice == 2) {
               role = "Mentor"
           }
           getManagerMailId()
           reportingId = if(found) {
               println("Enter the ReportingId listed above: ")
               s1.next()
           }else{
               println("Manager not available")
               "null"
           }
           val developer = Developer(empNo, empName, role, position, salary, phoneNumber, mailId, reportingId)
           emp.add(developer )
       } else if (position.equals("Manager", ignoreCase = true)) {
           role = "Manager"
           val manager = Manager(empNo, empName, role, salary, phoneNumber, mailId)
           emp.add(manager)
       }*/