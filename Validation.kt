package file2

class Validation {

    fun isValidId(id: String): Boolean {
        return id.matches(".*[a-zA-Z].*".toRegex()) && id.matches(".*[0-9].*".toRegex())
    }

    fun validateInteger(userInput: String): Boolean {
        return userInput.matches("\\d+".toRegex())
    }

    fun isValidName(name: String): Boolean {
        return name.matches("[a-z A-Z.']+|[a-z A-Z.']+\\s[a-z A-Z.']+".toRegex())
    }


    fun isValidMailId(mailId: String): Boolean {
        val pattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,18}".toRegex()
        return pattern.matches(mailId)
    }

    fun checkPhonenumber(num: String): Boolean {
        //Matching the given phone number with the expression
       val pattern = "(0/91)?[6-9][0-9]{9}".toRegex()
        return pattern.matches(num)
    }

    fun checkRange(role: String, salary: Int):Boolean
    {
        when(role) {
            "Trainee" -> return salary <= 15000
            "Developer" -> return salary <= 60000
            "Manager" -> return salary <= 90000
        }
        return true
    }

}