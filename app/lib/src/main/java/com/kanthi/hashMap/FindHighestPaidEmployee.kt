package com.kanthi.hashMap

fun main(){
    val employees = listOf(
        Employee("A", "IT", 50000),
        Employee("B", "IT", 80000),
        Employee("C", "HR", 60000),
        Employee("D", "HR", 90000)
    )

    println(highestPaidByDepartment(employees)) //map approach

    //groupBy groups elements that have the same key and returns a Map<Key, List<Value>>.
    //employees.groupBy { it.department }
    //IT → [A(50000), B(80000)]
    //HR → [C(60000), D(90000)]
    // .mapValues { (_, employees) -> employees.maxByOrNull { it.salary } }
    //goes through each department and finds the employee with the maximum salary.

    /*val result: Map<String, Employee?> = employees
        .groupBy { it.department }
        .mapValues { (_, employees) ->
            employees.maxByOrNull { it.salary }
        }
    println(result)*/
}

data class Employee(
    val name: String,
    val department: String,
    val salary: Int
)

fun highestPaidByDepartment(
    employees: List<Employee>
): Map<String, Employee> {

    val result = mutableMapOf<String, Employee>()

    for (employee in employees) {

        val currentHighest = result[employee.department]

        if (currentHighest == null ||
            employee.salary > currentHighest.salary
        ) {
            result[employee.department] = employee
        }
    }

    return result
}