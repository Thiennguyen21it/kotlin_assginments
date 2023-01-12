class Student(val id: String, var name: String, var age: Int, var major: String) {
     fun display() {
         println("ID: $id, Name: $name, Age: $age , Major: $major")
     }
 }
 
 class StudentCRUD {
     var students = mutableListOf<Student>()
     fun create(id: String, name: String, age: Int, major: String) {
         students.add(Student(id, name, age, major))
     }
     fun read(id: String) {
         for (student in students) {
             if (student.id == id) {
                 student.display()
                 return
             }
         }
         println("Student not found")
     }
     fun update(id: String, name: String, age: Int, major: String) {
         for (student in students) {
             if (student.id == id) {
                 student.name = name
                 student.age = age
                 student.major = major
                 return
             }
         }
         println("Student not found")
     }
     fun delete(id: String) {
         for (student in students) {
             if (student.id == id) {
                 students.remove(student)
                 return
             }
         }
         println("Student not found")
     }
 }
 
 fun main() {
     val studentCRUD = StudentCRUD()
     // studentCRUD.create("21it049", "Thien nguyen", 20,"IT")
     // studentCRUD.create("21it047", "Thien nguyen", 21,"IT")
     // studentCRUD.read("21it049")
     // studentCRUD.update("21it049", "Thien nguyen", 22,"IT")
     // studentCRUD.read("21it049")
     // studentCRUD.delete("21it049")
     // studentCRUD.read("21it049")

     // create menu 
     while (true) {
          println("1. Add student")
          println("2. Remove student")
          println("3. Edit student")
          println("4. Display students")
          println("5. Exit")
          print("Enter your choice: ")
          
          val choice = readLine()!!.toInt()
          when (choice) {
               1 -> {
                       print("Enter id: ")
                       val id = readLine()!!
                       print("Enter name: ")
                       val name = readLine()!!
                       print("Enter age: ")
                       val age = readLine()!!.toInt()
                       print("Enter major: ")
                       val major = readLine()!!
                       studentCRUD.create(id, name, age,major)
                       println("Student added successfully!")
               }
               2 -> {
                    print("Enter id of student to remove: ")
                    val id = readLine()!!
                    studentCRUD.delete(id)
                    println("Student removed successfully!")
               }
               3 -> {
                    print("Enter id of student to edit: ")
                    val id = readLine()!!
                    print("Enter new name: ")
                    val newName = readLine()!!
                    print("Enter new age: ")
                    val newAge = readLine()!!.toInt()
                    print("Enter new major: ")
                    val newMajor = readLine()!!
                    studentCRUD.update(id, newName, newAge, newMajor)
                    println("Student updated successfully!")
               }
               4 -> {
                    for (student in studentCRUD.students) {
                         student.display()
                    }
               }
               5 -> {
                    break
               }
          }
     }

 }
 