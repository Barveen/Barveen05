package file2

import java.util.*

fun main()
    {
        val obj = EmployeeOperation()
        var on = true
        var menuOption: Int
        val sc = Scanner(System.`in`)

        fun menu()
        {
            print("********************************")
            println("\n* 1 For Insert Employee        *" +
                    "\n* 2 For Display Employee       *" +
                    "\n* 3 For Delete Employee        *" +
                    "\n* 4 For Update Employee Record *" +
                    "\n* 5 For Assign Reporties       *" +
                    "\n* 6 For Search                 *" +
                    "\n* 7 For Sort                   *" +
                    "\n* 8 For Menu                   *" +
                    "\n* 0 for Exit                   *")
            println("********************************")
        }

        while (on) {
            menu()
            println("\nSelect a menu option that you want( 8 for Show Menu option): ")
            println("--------------------------------------------------------------")
            menuOption = sc.nextInt()

            when(menuOption) {
                1 -> {
                    var found = true
                    while (found) {
                        println(
                            "***************************" +
                                    "\n* Enter the number :      *" +
                                    "\n***************************" +
                                    "\n* 1 For Insert Trainees   *" +
                                    "\n* 2 For Insert Developers *" +
                                    "\n* 3 For Insert Manager    *" +
                                    "\n* 4 For Exit              *" +
                                    "\n***************************"
                        )
                        when (sc.nextInt()) {
                            1 -> obj.insertTrainee()
                            2 -> obj.insertDeveloper()
                            3 -> obj.insertManager()
                            4 -> found = false
                        }
                    }
                }
                2 -> {
                    var found = true
                    while (found) {
                        println(
                                    "\n***************************************" +
                                    "\n* Enter the number :                  *" +
                                            "\n***************************************" +
                                    "\n* 1 For Show All Employees            *" +
                                    "\n* 2 For Show Employee With No Mentors *" +
                                    "\n* 3 For Show Manager                  *" +
                                    "\n* 4 For Show Mentors                  *" +
                                    "\n* 5 For Show Trainees                 *" +
                                    "\n* 6 For Employee with no manager      *" +
                                    "\n* 7 For Employee Under Manager        *" +
                                    "\n* 8 For Exit                          *" +
                                    "\n***************************************"
                        )
                        when (sc.nextInt()) {
                            1 -> obj.showAllEmployee()
                            2 -> obj.employeeWithNoMentors()
                            3 -> obj.showManager()
                            4 -> obj.showMentors()
                            5 -> obj.showTrainees()
                            6 -> obj.employeeWithNoManagers()
                            8 -> found = false
                        }
                    }
                }

                3 -> obj.deleteEmployee()
                4 -> obj.updateEmployeeRecord()
                5 ->
                {
                    var found = true
                    while(found) {
                        println(
                                    "\n*************************************" +
                                    "\n* Enter the number :                *" +
                                            "\n*************************************" +
                                    "\n* 1 For Assign Mentors to Trainee   *" +
                                    "\n* 2 For Assign Manager to Employees *" +
                                    "\n* 3 For Exit                        *" +
                                            "\n*************************************")
                        when (sc.nextInt()) {
                            1 -> obj.assignMentorsToTrainee()
                            2 -> obj.assignManagers()
                            3 -> found = false
                        }
                    }
                }
                6 -> {
                    var found = true
                    while(found) {
                        println(
                                    "\n**************************************" +
                                    "\n * Enter the number                  *" +
                                            "\n**************************************"+
                                    "\n* 1 For search By Employee Id        *" +
                                    "\n* 2 For search By Employee Name      *" +
                                    "\n* 3 For search By Employee Position  *" +
                                    "\n* 4 For search By Employee Role      *" +
                                    "\n* 5 For Exit                         *" +
                                            "\n**************************************"
                        )
                        when (sc.nextInt()) {
                            1 -> obj.searchByEmployeeId()
                            2 -> obj.searchByEmployeeName()
                            3 -> obj.searchByEmployeePosition()
                            4 -> obj.searchByEmployeeRole()
                            5 -> found = false

                        }
                    }
                }
                7 -> {
                    var found = true
                    while(found) {
                        println(
                            "\n************************************" +
                                    "\n* Enter the number                 *" +
                                    "\n************************************" +
                                    "\n* 1 For sort By Employee Id        *" +
                                    "\n* 2 For sort By Employee Name      *" +
                                    "\n* 3 For search By Employee Salary  *" +
                                    "\n* 4 For Exit                       *" +
                                    "\n************************************"
                        )
                        when (sc.nextInt()) {
                            1 -> obj.sortByEmployeeId()
                            2 -> obj.sortByEmployeeName()
                            3 -> obj.sortBySalary()
                            4 -> found = false

                        }
                    }
                }
                8 -> menu()

                else -> {
                    println("Program Exited!")
                    on = false
                }
            }
    }
}