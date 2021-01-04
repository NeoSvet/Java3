package ru.neosvet.lesson7;

public class Test2 implements ITest {
    @BeforeSuite
    public void beforeTest() {
        System.out.println("Test 2 BeforeSuite");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("Test 2 AfterSuite");
    }

    @Test(priority = 4)
    public void test1() {
        System.out.println("Test 2.1");
    }

    @Test(priority = 3)
    public void test2() {
        System.out.println("Test 2.2");
    }

    @Test(priority = 2)
    public void test3() {
        System.out.println("Test 2.3");
    }

    @Test(priority = 1)
    public void test4() {
        System.out.println("Test 2.4");
    }
}
