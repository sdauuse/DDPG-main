package com.miao.algorithm.symbol;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> symbolTable = new OrderSymbolTable<>();

        symbolTable.put(1,"张三");
        symbolTable.put(2,"李四");
        symbolTable.put(5,"王五");
        symbolTable.put(6,"小6");

        for (String s1 : symbolTable) {
            System.out.println(s1);
        }

        System.out.println(symbolTable.size());

        symbolTable.delete(2);
        System.out.println(symbolTable.size());

        symbolTable.put(5,"小5");
        String s = symbolTable.get(5);
        System.out.println(s);



    }
}
