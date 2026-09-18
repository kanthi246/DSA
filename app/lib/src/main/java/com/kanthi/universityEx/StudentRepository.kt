package com.kanthi.universityEx

/** Identifier shared by students and courses. */
typealias Id = Int

/** Student and the courses they subscribe to. */
data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)
/** Course metadata, including whether payment is required. */
data class Course(val id: Id, val name: String, val isPaid: Boolean)

val kotlinCourse = Course(id = 1, name = "Kotlin", isPaid = true)
val androidCourse = Course(id = 2, name = "Android", isPaid = true)
val javaCourse = Course(id = 3, name = "Java", isPaid = false)
val composeCourse = Course(id = 4, name = "Jetpack Compose", isPaid = true)

val student1 = Student(id = 1, name = "Kiran", subscribedCourses = listOf(
    kotlinCourse,
    androidCourse))

val student2 = Student(id = 2, name = "Ravi", subscribedCourses = listOf(
    kotlinCourse,
    composeCourse))

val student3 = Student(id = 3, name = "Ram", subscribedCourses = listOf(
    kotlinCourse,
    androidCourse,
    javaCourse))

val student4 = Student(id = 4, name = "Suresh", subscribedCourses = listOf(
    composeCourse))

/** Supplies a list of student-like records. */
interface Repository<T> {
    /** Returns the available records. */
    fun getStudents(): List<T>
}


/** In-memory source of sample students. */
class StudentRepository : Repository<Student> {

    private val students = listOf(
        student1,
        student2,
        student3,
        student4
    )

    /** Returns the sample students. */
    override fun getStudents(): List<Student> {
        return students
    }
}
