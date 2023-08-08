package com.scaler.javabasicsp1;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {

        // the fact is this will throw an error, since creation of SampleNestedClass
        // will need a prior init of Sample class, because SampleNestedClass will be an
        // class inside object of Sample class

        // the solution is creating a static class to do so

        // STATIC NESTED CLASS
        SampleNestedClass obj1 = (new SampleNestedClass("attr1", "attr2"));
        // Sample.SampleNestedClass obj2 = new SampleNestedClass("attr1", "attr2"); //
        // will work the same as above

        // NON-STATIC NESTED CLASS:
        Sample.SampleNonStaticNestedClass obj3 = new Sample().new SampleNonStaticNestedClass(null, null);

        List<Object> listObj = new ArrayList<>();
        listObj.add(new Object());

        List<String> listString;
        listString = listObj; // will thorw an error

        List<Object> obj = listString; // will throw an error

    }

    static class SampleNestedClass {
        String attribute1;
        String attribute2;

        public SampleNestedClass(String attr1, String attr2) {
            super();
            this.attribute1 = attr1;
            this.attribute2 = attr2;
        }
    }

    class SampleNonStaticNestedClass {
        String attribute1;
        String attribute2;

        public SampleNonStaticNestedClass(String attr1, String attr2) {
            super();
            this.attribute1 = attr1;
            this.attribute2 = attr2;
        }
    }
}

/*
 * Notes:
 * All about Static:
 * - a function can be made static if it is nodt dependent on an object
 * - e.g if you want to create a copy of object using
 * "Object copy(Object oldObject) {return new Object(oldObject); }"
 * - now this can be made static since this is object agnostic
 * 
 * - if every function is made static then it would be more of a Procedural
 * Coding, because OOP is heavily working with objects and less of static things
 * unless required
 *
 * 
 */