package com.kanthi.universityEx


fun main(){

    val university = University(StudentRepository())
    university.getPaidCoursesWithTheNumbersOfSubscribedStudents(2)

}

class University(private val repository: StudentRepository) {

    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(
        coursesCount: Int
    ): Map<Course, Int> {


        val repository = repository.getStudents()

        //get all students that are subscribed
        val subscribedCourses = repository.flatMap { it.subscribedCourses }
        //Takes each student's subscribedCourses and combines all course lists into one list
        println("subscribedCourses $subscribedCourses")

        val filterPaid = subscribedCourses.filter { it.isPaid }
        //Keeps only courses where isPaid == true
        println("filterPaid $filterPaid")

        val groupingCount = filterPaid.groupingBy { course -> course }.eachCount()
        //Groups the same courses together
        println("grouping $groupingCount")

        val entries = groupingCount.entries
        //Converts the map into key-value entries so we can sort them
        println("entries $entries")

        val sortDesc = entries.sortedByDescending { it.value }
        //Sorts courses by student count, highest first
        println("sortDesc $sortDesc")

        val take = sortDesc.take(coursesCount)
        //Keeps only the requested top number of courses
        println("take $take")

        val associate = take.associate { entry -> entry.key to entry.value }
        //Converts the result back into Map<Course, Int>
        println("associate $associate")

        return repository
            .flatMap { student ->
                student.subscribedCourses
            }
            .filter { course ->
                course.isPaid
            }
            .groupingBy { course ->
                course
            }
            .eachCount()
            .entries
            .sortedByDescending { entry ->
                entry.value
            }
            .take(coursesCount)
            .associate { entry ->
                entry.key to entry.value
            }
    }
}
