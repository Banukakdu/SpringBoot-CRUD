package com.example.crudapp.Services;

import com.example.crudapp.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public List Findall();

    public StudentDto findById(Integer id);

    public StudentDto save(StudentDto s);

    public Integer deletebyid(Integer id);

    public StudentDto update(StudentDto s);
}
