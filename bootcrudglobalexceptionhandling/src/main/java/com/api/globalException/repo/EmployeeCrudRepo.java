package com.api.globalException.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.globalException.entity.Employee;

public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {

}


