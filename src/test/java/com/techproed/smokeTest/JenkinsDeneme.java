package com.techproed.smokeTest;

import org.testng.annotations.Test;

public class JenkinsDeneme {

    @Test (groups = "mahmut")
    public void deneme(){
        System.out.println("mahmut");
    }

    @Test (groups = "mahmut")
    public void deneme2(){
        System.out.println("necip");
    }
}
