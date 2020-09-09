package com.example.crudapp.Services.impl;

import com.example.crudapp.Services.StudentService;
import com.example.crudapp.dto.StudentDto;
import com.example.crudapp.entity.Student;
import com.example.crudapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List Findall() {
        List<StudentDto> studentDtos=new ArrayList<>();
        List<Student> all = studentRepository.findAll();

        Iterator<Student> iterator = all.iterator();

        while (iterator.hasNext()){
            Student next = iterator.next();
            StudentDto studentDto = new StudentDto();

            studentDto.setId(next.getId());
            studentDto.setAge(next.getAge());
            studentDto.setName(next.getName());
            studentDto.setYear(next.getYear());

            studentDtos.add(studentDto);


        }
        return studentDtos;
    }
    @Override
    public StudentDto findById(Integer id){
        Optional<Student> optionalStudent =studentRepository.findById(id);
        StudentDto studentDto= new StudentDto();
        if(optionalStudent.isPresent()){
            Student optional=optionalStudent.get();
            studentDto.setId(optional.getId());
            studentDto.setAge(optional.getAge());
            studentDto.setName(optional.getName());
            studentDto.setYear(optional.getYear());

        }
        return studentDto;

    }

    @Override
    public StudentDto save(StudentDto s) {


        Student student = new Student();
       //student.setId(s.getId());
        student.setName(s.getName());
        student.setYear(s.getYear());
        student.setAge(s.getAge());
        Student save = studentRepository.save(student);
        s.setId(save.getId());
        return s;
    }
    @Override
    public Integer deletebyid(Integer id){
        studentRepository.deleteById(id);
        return id;
    }

    @Override
    public StudentDto update(StudentDto s) {
        Student student=new Student();
        student.setName(s.getName());
        student.setYear(s.getYear());
        student.setId(s.getId());
        student.setAge(s.getAge());
        Student save=studentRepository.save(student);
        s.setId(save.getId());
        return s;

    }


}
