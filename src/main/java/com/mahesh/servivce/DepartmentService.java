package com.mahesh.servivce;

import com.mahesh.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getAllDepartmets();

    DepartmentDTO saveDepartment(DepartmentDTO inputDepartment);

    DepartmentDTO updateDepartment(Long id, DepartmentDTO dep);

    boolean deleteDepartmentById(Long id);
}
