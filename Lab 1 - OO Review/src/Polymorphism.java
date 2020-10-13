import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        Person jennifer = new Person("Jennifer", 40);
        Person michael = new Employee("Michael", 56, 370_000, "Dunder Mifflin");
        Person david = new Manager("David", 39, 13_000_000, "Dunder Mifflin");

        people.add(jennifer);
        people.add(michael);
        people.add(david);

        for (int i = 0; i < people.size(); i++) {
            Person p = people.get(i);
            System.out.println(p.toString());
        }

        /* Look at and run the code above, then take a moment to think about the
         * following questions. Write down your answers somewhere.
         *
         * 1. How is it that we were able to store an Employee or a Manager in a
         * variable that has a type Person?
         * 
         * We can store and Employee or a Manager in a variable of type Person because Employee/Manager IS A Person.
         * They both extend Person and will all contain the same base functionality.
         *
         * 2. When we called the toString() method on each of the people in the
         * list, it resulted in something totally different. Why? They're all
         * stored in variables of type Person, so why would they not be the
         * same?
         * 
         * Each toString is not the same because of polymorphism in classes. When a method is called within a class,
         * that classes method is called, then it progresses up the chain if needed.
         *
         * 3. We wrote three different versions of toString() across three
         * different classes. When we call p.toString(), which one of these
         * versions does Java use, and why?
         * 
         * Java uses the toString closest to the type of person. This is due to the precedence of the methods and how
         * Java allows you to duplicate and edit methods with the same name. Polymorphism.
         */

         // Consider the following code:
         //michael.setSalary(800000);

         /* 
          * 4. Will this code cause errors? Uncomment it and see.
          * 
          * Yes, the type of michael is a person, yet we assign it to an employee. The compiler does not know whether
          * or not michael will actually be an employee, so it throws an error because the Person class doesn't have 
          * setSalary().
          *
          * 5. You should have found that the above code results in a
          * compilation error. Why can't Java figure out what to do? Employee
          * has a perfectly valid setSalary method, doesn't it?
          * 
          * This has to do with what java does at compile time. It has no way of knowing whether michael is truly an employee.
          */

         /* Now consider this code: */
         Employee anotherMichael = new Employee("Michael", 56, 370000, "Dunder Mifflin");

         /* This is the exact same person as above, the only difference is that
          * we've stored it in a variable of type Employee instead of a variable
          * of type Person. If we try */

         anotherMichael.setSalary(800000);

         /* Will it work? Make a guess, then uncomment the line and see.
          *
          * 6. You should have found that this code DOES NOT produce a
          * compilation error. Why?
          * 
          * This does not produce an error because anotherMichael IS A Employee, so the employee methods are allowed to be 
          * called whenever. There is a guarantee that anotherMichael is an Employee.
          */

         /* 7. What you have just seen in action from the previous few questions
          * is known as dynamic binding. Describe what dynamic binding is, in
          * your own words.
          * 
          * Dynamic binding is the run-time version of inheritance and polymorphism. The type is assigned while the 
          * program is running.
          */
    }
}
