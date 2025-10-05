package org.learnjava.p01_lang;

/*
    1. Regular Object References in Java
        Java is pass-by-value, even for objects. But what gets passed is the value of the reference, not the object itself.
    2. When you pass an object to a method:
        - You can mutate its fields inside the method.
        - But you cannot reassign the reference itself and expect that change to reflect outside the method.

    3. simulating Pass-by-Reference
        Ref<T> is a wrapper class that holds a mutable reference to an object. It’s often used to simulate pass-by-reference behavior—like in C++ or C#—where you want to reassign the object itself inside a method.

*/
public class S12_Reference {
    class User {
        String name;

        User(String name) {
            this.name = name;
        }
    }

    //1. Regular Object References in Java
    void updateUser(User user) {
        user.name = "Updated";         // ✅ This works
        user = new User("NewUser");    // ❌ This does NOT affect the original reference
    }

    void runOne() {
        User user = new User("Original");
        updateUser(user);
        System.out.println(user.name); // Outputs "Updated", not "NewUser"
    }

    class Ref<T> {
        public T value;

        public Ref(T value) {
            this.value = value;
        }
    }

    //2. simulating Pass-by-Reference
    void updateUserRef(Ref<User> ref) {
        ref.value = new User("NewUser"); // ✅ This change is visible outside
    }

    void runTwo() {
        Ref<User> userRef = new Ref<>(new User("Original"));
        updateUserRef(userRef);
        System.out.println(userRef.value.name); // Outputs "NewUser"
    }

    void mainAll() {
        runOne();
        runTwo();
    }

    public static void main(String[] args) {
        System.out.println("start of prg");

        new S12_Reference().mainAll();


        System.out.println("end of prg");
    }

}
