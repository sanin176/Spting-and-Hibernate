package com.howtodoinjava.demo.model;

import com.howtodoinjava.demo.ClassForOutDataFromJSP.StudentFromJSP;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    public static Student from(StudentFromJSP form) {
        return Student.builder()
                .name(form.getName())
                .surname(form.getSurname())
                .build();
    }
}
