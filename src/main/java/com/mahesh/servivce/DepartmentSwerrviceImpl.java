package com.mahesh.servivce;

import com.mahesh.dto.DepartmentDTO;
import com.mahesh.entites.DepartmentEntity;
import com.mahesh.exceptions.ResourceNotFoundException;
import com.mahesh.respository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentSwerrviceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentSwerrviceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartmentDTO> getAllDepartmets() {

        List<DepartmentEntity> departmentEntities= departmentRepository.findAll();

        return departmentEntities.stream()
                .map(departmentEntitie->modelMapper.map(departmentEntitie, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO inputDepartment) {
        DepartmentEntity toSaveEntity = modelMapper.map(inputDepartment, DepartmentEntity.class);
        DepartmentEntity savedEmployeeEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(Long id, DepartmentDTO dep) {
        isExistsByDepartmentId(id);
        DepartmentEntity employeeEntity = modelMapper.map(dep, DepartmentEntity.class);
        employeeEntity.setId(id);
        DepartmentEntity savedEmployeeEntity = departmentRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity,DepartmentDTO.class);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {
        isExistsByDepartmentId(id);
        departmentRepository.deleteById(id);
        return true;
    }

    public void isExistsByDepartmentId(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Department not found with id: "+id);
    }
}
