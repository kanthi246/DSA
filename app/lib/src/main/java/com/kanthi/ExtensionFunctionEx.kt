package com.kanthi

//Question : Write an extension method to filter employees list whose age is greater than 30

/** Sample employee data for the filtering examples. */
data class Employee(val name: String, val age: Int, val designation: String)

/** Creates sample employees for the filtering examples. */
fun getEmployeeList(): List<Employee> {
    val employeesList = mutableListOf<Employee>()
    var employee = Employee("Neel", 26, "Tech Lead")
    employeesList.add(employee)
    employee = Employee("Mani", 29, "Tech Lead")
    employeesList.add(employee)
    employee = Employee("Karn", 35, "Tech Lead")
    employeesList.add(employee)
    employee = Employee("Rahul", 38, "Senior SE")
    employeesList.add(employee)
    employee = Employee("Anand", 39, "Engineer")
    employeesList.add(employee)
    return employeesList
}

/** Compares regular and extension-function filtering. */
fun main() {
    val employeeList = getEmployeeList()
    println(employeeList)

    println(filterEmployees(employeeList))

    println(employeeList.filterList())
}


/** Returns employees older than 30 from this list. */
fun List<Employee>.filterList(): List<Employee>{
    return this.filter {it.age > 30}
}

/** Returns employees older than 30 from [employeeList]. */
fun filterEmployees(employeeList:List<Employee>):List<Employee>{
    return employeeList.filter {it.age >30}
}
