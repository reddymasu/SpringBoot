package com.mahesh.controller;


import com.mahesh.dto.DepartmentDTO;
import com.mahesh.servivce.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments()
    {
        return ResponseEntity.ok(departmentService.getAllDepartmets());
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody @Valid DepartmentDTO inputDepartment)
    {
        DepartmentDTO departmentDTO = departmentService.saveDepartment(inputDepartment);
        return new ResponseEntity<>(departmentDTO, HttpStatus.CREATED);
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody @Valid DepartmentDTO dep,@PathVariable Long id)
    {
        return ResponseEntity.ok(departmentService.updateDepartment(id,dep));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long id) {
        boolean gotDeleted = departmentService.deleteDepartmentById(id);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }






}
