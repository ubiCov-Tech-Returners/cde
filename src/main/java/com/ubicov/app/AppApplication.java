/**
 * Hard coding dummy data to test react async calls to spring boot.
 * NB.  Remove before production release.
 */
package com.ubicov.app;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:3000")  // set to local React front end server port
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println(name);
        return String.format("Hello %s!", name);
    }

    @GetMapping("/suppliers")
    public List supplier() {
        List lst = new ArrayList<>();
        lst.add(new Supplier(1L, "name1", "pic1"));
        lst.add(new Supplier(2L, "name2", "pic2"));
        lst.add(new Supplier(3L, "name3", "pic3"));

        return lst;
    }

    @Entity @Getter
    @Setter @NoArgsConstructor
    @ToString @EqualsAndHashCode
    public class Supplier {
        @Id
        private long supplierId;
        private String name;
        private String logo;

        public Supplier(long suppId, String name, String logo){
            this.name = name;
            this.supplierId = suppId;
            this.logo = logo;
        }
    }


}
