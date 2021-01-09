package com.bl.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "employee")
@ToString
@AllArgsConstructor
public class EmployeePayroll {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;
    private String salary;
    private String gender;

    @ElementCollection(fetch=FetchType.EAGER)
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
    private List<String> department;

    private String startDate;
    private String notes;
    private String profile;

    public EmployeePayroll(){

    }

    public EmployeePayroll(@NonNull String name, String salary, String gender, List<String> department, String startDate, String notes, String profile) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.department = department;
        this.startDate = startDate;
        this.notes = notes;
        this.profile = profile;
    }

}
