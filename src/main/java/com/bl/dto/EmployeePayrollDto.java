package com.bl.dto;

import com.bl.model.EmployeePayroll;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Getter
@Setter
@JsonIgnoreProperties
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeePayrollDto {
    private Long id;

    @NotNull(message = "Name cannot be null!")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee Name Invalid!")
    private String name;

    @NotNull(message = "Salary cannot be null!")
    @Min(value = 500, message = "Min Wage Should Be More Than 500!")
    private String salary;

    @NotNull(message = "Gender cannot be null!")
    @NotEmpty(message = "Gender Can't Be Empty!")
    private String gender;

    @NotNull(message = "Department cannot be null!")
    @NotEmpty(message = "Department Can't Be Empty!")
    private List<String> department;

    @NotNull(message = "Start Date cannot be null!")
    @NotEmpty(message = "Start Date Can't Be Empty!")
    private String startDate;

    private String notes;

    @NotNull(message = "Profile pic cannot be null!")
    private String profile;


    public EmployeePayrollDto(EmployeePayroll user){
        this.id = user.getId();
        this.name = user.getName();
        this.salary = user.getSalary();
        this.gender = user.getGender();
        this.department = user.getDepartment();
        this.startDate = user.getStartDate();
        this.notes = user.getNotes();
        this.profile = user.getProfile();
    }

}
