package file2

class UserInput {
    private val validation = Validation()

    fun inputId(): String {
        var id: String
        while (true) {
            id = readLine().toString()
            if (!validation.isValidId(id)) {
                println("Invalid id")
            } else {
                break
            }
        }
        return id
    }

    fun inputName(): String {
        var name: String
        while (true) {
            name = readLine().toString()
            if (!validation.isValidName(name)) {
                println("Invalid name")
                println("Please re-enter here")
            } else {
                break
            }
        }
        return name
    }

    fun inputPhoneNumber(): String {
        var phNum: String
        while (true) {
            println("Enter the phone number(Ex: 10- digits, Start's with 7 to 9)")
            phNum = readLine().toString()
            if (!validation.checkPhonenumber(phNum)) {
                println("Invalid Phone Number")
            } else {
                break
            }
        }
        return phNum
    }

    fun inputMailId(): String {
        var mailId: String
        while (true) {
            println("Enter the mailId")
            mailId = readLine().toString()
            if (!validation.isValidMailId(mailId)) {
                println("Invalid MailId")
            } else {
                break
            }
        }
        return mailId
    }

    fun inputInteger(role: String): Int {
        var userInput: String
        while (true) {
            userInput = readLine().toString()
            if (!validation.validateInteger(userInput)) {
                println("Invalid input")
            } else {
                if (!validation.checkRange(role,userInput.toInt())) {
                    println("Please enter correct Salary")
                } else {
                    break
                }
            }
        }
        return userInput.toInt()
    }
}