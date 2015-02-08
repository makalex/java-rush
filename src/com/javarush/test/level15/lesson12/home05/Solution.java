package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution() {}
    public Solution(int a, int b) {}
    public Solution(int a, int b, int c) {}


    protected Solution(float a) {}
    protected Solution(float a, float b) {}
    protected Solution(float a, float b, float c) {}


    Solution(double a) {}
    Solution(double a, double b) {}
    Solution(double a, double b, double c) {}


    private Solution(String a) {}
    private Solution(String a, String b) {}
    private Solution(String a, String b, String c) {}
}

