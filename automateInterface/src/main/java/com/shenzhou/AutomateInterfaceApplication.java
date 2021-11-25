package com.shenzhou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
public class AutomateInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutomateInterfaceApplication.class,args);
    }
}
