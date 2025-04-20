package org.learnjava.p01_lang;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/*
    1. WeakReference: WeakReference is used to create a weak reference to an object.
    2. Refer
        https://www.youtube.com/watch?v=S3yXKylZGc8
        https://www.youtube.com/watch?v=9mRBx8F5hIk
    3. If you need to ensure that an object is reclaimed as soon as it is no longer strongly reachable, use a WeakReference.
       If you want to keep an object in memory as long as possible, but you are willing to discard it if memory becomes scarce (in short supply), use a SoftReference.

 */

public class S42_References {

    class User {
    }

    /*
        1. A WeakReference does not prevent the garbage collector from reclaiming the object it refers to if that object is only weakly reachable. An object is weakly reachable if the only references to it are weak references. The garbage collector is free to reclaim the object at any time after it becomes weakly reachable, typically during the next garbage collection cycle. Weak references are useful for implementing data structures like canonicalizing mappings, where you want to maintain a mapping from keys to values as long as the keys are still in use, but you don't want to prevent the keys from being garbage collected if they are no longer needed.
    */
    public void usingWeakReference() {
        User s1 = new User();
        WeakReference<User> weakReference = new WeakReference<>(s1);
        System.out.println(weakReference.get());
        s1 = null;
        System.gc();
        System.out.println(weakReference.get()); // null
    }

    /*
        1. A SoftReference is similar to a WeakReference, but the garbage collector is more reluctant to reclaim objects that are only softly reachable. An object is softly reachable if the only references to it are soft references (or weak references). The garbage collector will only reclaim a softly reachable object if it is running low on memory. Soft references are suitable for implementing memory-sensitive caches, where you want to keep objects in memory as long as possible, but you are willing to discard them if memory becomes scarce.
    */
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
