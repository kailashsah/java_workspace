package org.learnjava.p01_lang;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
    1. WeakReference: WeakReference is used to create a weak reference to an object.
    2. Refer
        https://www.youtube.com/watch?v=S3yXKylZGc8
        https://www.youtube.com/watch?v=9mRBx8F5hIk
 */

public class S42_References {

    class User {
    }

    public void usingWeakReference() {
        User s1 = new User();
        WeakReference<User> weakReference = new WeakReference<>(s1);
        System.out.println(weakReference.get());
        s1 = null;
        System.gc();
        System.out.println(weakReference.get()); // null
    }

    public void usingSoftReference() {

        User s1 = new User();
        SoftReference<User> softReference = new SoftReference<>(s1);
        System.out.println(softReference.get());
        s1 = null;
        System.gc();

        System.out.println(softReference.get());  // has some value as reference

    }

    public static void main(String[] args) {
        new S42_References().usingWeakReference();
        new S42_References().usingSoftReference();
    }
}
