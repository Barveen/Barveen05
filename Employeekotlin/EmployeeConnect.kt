package file2
import java.util.ArrayList

class EmployeeConnect: EmployeeInterface {
    var employee: MutableList<Employee2> = ArrayList()
    var mailId: String = ""
    private var found = false
    private var count: Int = 0

    override fun insertTrainee(trainee: Trainee): Boolean {
        employee.add(trainee)
        return true
    }

    override fun insertDeveloper(developer: Developer): Boolean {
        employee.add(developer)
        return true
    }

    override fun insertManager(manager: Manager): Boolean {
        employee.add(manager)
        return true
    }

    /*
    override fun getMentorMailId(): Array<String>? {
        var arr: Array<String>? = null
        for (i in employee) {
            arr = if (i.role == "Mentor") {
                arrayOf(i.eMailId)
            } else{
                null
            }
        }
        return arr
    }*/
    override fun getMentorMailId(count: Int, name: String): Array<String>? {
        var arr: Array<String>? = null
        for (i in employee) {
            if(i is Developer)
            when (count) {
                1 -> {
                    if (i.employeeName == name)
                        arr = arrayOf(i.eMailId)
                }
                2 -> {
                    if (i.role == name) {
                        arr = arrayOf(i.eMailId)
                    }
                }
                else -> arr = emptyArray()
            }
        }
        return arr
    }


    override fun showEmployee(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            emp.add(i)
        }
        return emp
    }

    override fun getManagerMailId(count: Int,name : String): Array<String>? {
        var arr: Array<String>? = null
        for (i in employee) {
            when (count) {
                1 -> {
                    if (i.employeeName == name)
                        arr = arrayOf(i.eMailId)
                }
                2 -> {
                    if (i.role == name) {
                        arr = arrayOf(i.eMailId)
                    }
                }
                else -> arr = null
            }
        }
        return arr
    }

    override fun employeeWithNoMentors(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        //var arr: Array<String>? = null
        for (i in employee) {
            if (i is Trainee)
                if (i.mentorMailId.equals("null", true)) {
                   emp.add(i)
                }
        }
        return emp
    }

    override fun employeeWithNoManagers():  MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
       // var arr: Array<String>? = null
        for (i in employee) {
            if (i is Developer)
                if (i.reportingId.equals("null", true)) {
                   emp.add(i)
                }
        }
        return emp
    }

    override fun updateEmployeeRecord(count: Int,empId : String, updatedField: String): Boolean {
        for(i in employee) {
            if (i.employeeId == empId) {
                return when (count) {
                    1 -> {i.employeeName = updatedField
                        true
                    }
                    2 -> {i.salary = updatedField
                        true
                    }
                    3 -> {i.eMailId = updatedField
                        true
                    }
                    4 -> {i.phoneNumber = updatedField
                        true
                    }
                    else -> false
                }
            }
        }
        return true
    }

    override fun deleteEmployee(employeeId: String): Boolean {
        for (i in employee) {
            if (i.employeeId == employeeId) {
                if (i.role == "Mentor") {
                    mailId = i.eMailId
                    count = 1
                } else if (i.role == "Manager") {
                    mailId = i.eMailId
                    count = 1
                }
                employee.remove(i)
                found = true
                break
            }
        }
        if (found || count == 1) {
            deleteReportingMailId(mailId)
        }
        return true
    }

    private fun deleteReportingMailId(mail: String) {
        for (e in employee) {
            if (e is Trainee) {
                if (e.mentorMailId == mail) {
                    e.mentorMailId = null
                }
            } else if (e is Developer)
                if (e.reportingId == mailId)
                    e.reportingId = null
        }
    }

    override fun searchByEmployeeId(employeeId: String): Employee2? {
        var employee1: Employee2? = null
        for (i in employee) {
            if (i.employeeId == employeeId) {
                employee1 = i
            }
        }
        return employee1
    }

    override fun searchByEmployeeName(employeeName: String): Employee2? {
        var employee1: Employee2? = null
        for (i in employee) {
            if (i.employeeName == employeeName) {
                employee1 = i
            }
        }
        return employee1
    }

    override fun searchByEmployeePosition(position: String): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            if (i is Trainee || i is Developer || i is Manager) {
                emp.add(i)
            }
        }
        return emp
    }

    override fun searchByEmployeeRole(role: String): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            if (i.role == role) {
                emp.add(i)
            }
        }
        return emp

    }

    override fun showManager(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            if (i.role == "Manager") {
                emp.add(i)
            }
        }
        return emp
    }

    override fun showMentors(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            if (i.role == "Mentor") {
                    emp.add(i)
                }
        }
        return emp
    }

    override fun showTrainees(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        for (i in employee) {
            if (i.role == "Incubation Trainee" || i.role == "Project Trainee") {
                emp.add(i)
            }
        }
        return emp
    }

    override fun assignMentorsToTrainee(traineeName: String,mentorName : String): Boolean {
        var id : String? = null
        val arr: Array<String> ?= getMentorMailId(1,mentorName)
        if (arr != null) {
            repeat(arr.count()) { id = arr[0]
            found = true}
        }else{return false}
        if(found) {
            for (i in employee) {
                if (i is Trainee) {
                    if (i.employeeName == traineeName) {
                        i.mentorMailId = id
                        return true
                    }
                }
            }
        }

        return true
    }

    override fun assignManager(traineeName: String,mentorName : String): Boolean {
        var id : String? = null
        val arr: Array<String> ?= getManagerMailId(1,mentorName)
        if (arr != null) {
            repeat(arr.count()) { id = arr[0]
                found = true}
        }else{return false}
        if(found) {
            for (i in employee) {
                if (i is Developer) {
                    if (i.employeeName == traineeName) {
                        i.reportingId = id
                        return true
                    }
                }
            }
        }

        return true
    }

    override fun sortBySalary(): MutableList<Employee2> {
        val emp: MutableList<Employee2> = ArrayList()
        employee.sortedByDescending { it.salary }
        employee.forEach { emp.add(it) }
        return emp
    }

    override fun sortByEmployeeId(): MutableList<Employee2>
    {
        val emp: MutableList<Employee2> = ArrayList()

        employee.sortedBy { it.employeeId }
        employee.forEach { emp.add(it) }
        return emp
    }

    override fun sortByEmployeeName(): MutableList<Employee2>
    {
        val emp: MutableList<Employee2> = ArrayList()

        employee.sortedBy { it.employeeName }
        employee.forEach { emp.add(it) }
        return emp
    }
}

