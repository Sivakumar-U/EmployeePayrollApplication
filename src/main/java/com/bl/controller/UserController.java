package com.bl.controller;

import com.bl.dto.EmployeePayrollDto;
import com.bl.dto.ResponseDto;
import com.bl.exceptions.PayrollException;
import com.bl.exceptions.UserNotFoundException;
import com.bl.service.EmployeePayrollService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    EmployeePayrollService employeePayrollService;

    @PostMapping("/employee-payroll/create")
    @ApiOperation("For registration")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public ResponseEntity<ResponseDto> createUser(@Valid @RequestBody EmployeePayrollDto user){
        ResponseDto responseDto = new ResponseDto("Employee Record Created Succesfully", employeePayrollService.CreateUser(user));
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/employee-payroll/update")
    @ApiOperation("to update")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody EmployeePayrollDto user){
        ResponseDto responseDto = new ResponseDto("Employee Record Updated Succesfully", employeePayrollService.UpdateUser(user));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/employee-payroll/delete/{id}")
    @ApiOperation("to delete")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Long id){
        ResponseDto responseDto = new ResponseDto("Employee Record Deleted Succesfully", employeePayrollService.deleteUser(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.ACCEPTED);
    }

    @GetMapping("/employee-payroll/get")
    @ApiOperation("to get all users")
    public ResponseEntity<ResponseDto> getAllUser(){
    	List<EmployeePayrollDto> allUser = employeePayrollService.getAllUser();
        ResponseDto responseDto = new ResponseDto("Displaying All Records in DB",allUser );
        System.out.println(responseDto);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/employee-payroll/getbyid")
    @ApiOperation("to get by id")
    @CrossOrigin(allowedHeaders = "*", origins = "*")
    public ResponseEntity<ResponseDto> getUser(Long id){
        ResponseDto responseDto = new ResponseDto("Displaying Records With ID " + id, employeePayrollService.getUser(id));
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
