package com.example.crudapp.controller;


import com.example.crudapp.Services.StudentService;
import com.example.crudapp.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("${application.api}/student")
public class StudentController {

    @Autowired
    StudentService studentService;

@GetMapping("/")
    public List<StudentDto> findall(){
    List<StudentDto> list = studentService.Findall();
    return  list;
}
@GetMapping("/{id}")
   public StudentDto findById(@PathVariable("id") Integer id){
    StudentDto studentDto=studentService.findById(id);
    return studentDto;
}
@PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto s){
    StudentDto studentDto=studentService.save(s);
    return studentDto;
}
@DeleteMapping("/delete/{id}")
    public Integer delete(@PathVariable("id")Integer id){
    studentService.deletebyid(id);
    return id;
}
@PostMapping("/update")
    public StudentDto update(@RequestBody StudentDto s){
    StudentDto studentDto=studentService.update(s);
    return studentDto;
}

}
