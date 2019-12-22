package appa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Outer {

    public Outer() {
        System.out.println("outer constructor");
    }

    @BeforeEach
    void outerBefore() {
        System.out.println("outer before");
    }

    @Test
    void outer() {
        System.out.println("outer");
    }

    @AfterEach
    void outerAfter() {
        System.out.println("outer after");
        System.out.println("---------------");
    }

    @Nested
    class NestedA {

        public NestedA() {
            System.out.println(">> A constructor");
        }

        @BeforeEach
        void nestedBefore() {
            System.out.println(">> A-before");
        }

        @AfterEach
        void nestedAfter() {
            System.out.println(">> A-after");
        }

        @Test
        void nested1() {
            System.out.println(">> A-a1");
        }

        @Test
        void nested2() {
            System.out.println(">> A-a2");
        }
    }

    @Nested
    class NestedB {

        public NestedB() {
            System.out.println(">> B constructor");
        }

        @BeforeEach
        void setUp() {
            System.out.println(">> B-before");
        }

        @Test
        void b1() {
            System.out.println(">> B-a1");
        }

        @Test
        void b2() {
            System.out.println(">> B-a2");
        }

        @AfterEach
        void tearDown() {
            System.out.println(">> B-after");
        }
    }
}
