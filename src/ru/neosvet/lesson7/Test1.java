package ru.neosvet.lesson7;

public class Test1 implements ITest {
    @BeforeSuite
    public void beforeTest() {
        System.out.println("Test 1 BeforeSuite");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("Test 1 AfterSuite");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("Test 1.1");
    }

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 1.2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 1.3");
    }

    @Test(priority = 4)
    public void test4() {
        System.out.println("Test 1.4");
    }
}
