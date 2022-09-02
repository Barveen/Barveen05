package file2

interface EmployeeInterface {
    fun insertTrainee(trainee: Trainee): Boolean
    fun insertDeveloper(developer: Developer): Boolean
    fun insertManager(manager: Manager): Boolean
    fun getMentorMailId(count: Int, name: String):  Array<String>?
    fun getManagerMailId(count: Int,name : String):  Array<String>?
    fun showEmployee() : MutableList<Employee2>
    fun employeeWithNoMentors() : MutableList<Employee2>
    fun employeeWithNoManagers() : MutableList<Employee2>
    fun deleteEmployee(employeeId:String) : Boolean
    fun searchByEmployeeId(employeeId:String): Employee2?
    fun searchByEmployeeName(employeeName: String): Employee2?
    fun searchByEmployeePosition(position: String): MutableList<Employee2>
    fun searchByEmployeeRole(role: String): MutableList<Employee2>
    fun updateEmployeeRecord(count: Int,empId : String,updatedField: String):Boolean
    fun showManager(): MutableList<Employee2>
    fun showMentors(): MutableList<Employee2>
    fun showTrainees(): MutableList<Employee2>
    fun assignMentorsToTrainee(traineeName:String,mentorName : String):Boolean
    fun assignManager(traineeName: String, mentorName: String): Boolean
    fun sortBySalary(): MutableList<Employee2>
    fun sortByEmployeeId(): MutableList<Employee2>
    fun sortByEmployeeName(): MutableList<Employee2>


}