package com.miao;

import org.junit.jupiter.api.Test;

public class uploadTest {

    @Test
    public void testUpload(){
        String fileName = "adasdsa12.jpg";
        String substring = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(substring);
    }
}
