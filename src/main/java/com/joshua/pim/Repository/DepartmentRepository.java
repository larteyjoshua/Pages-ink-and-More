package com.joshua.pim.Repository;

import com.joshua.pim.Model.Department;
import com.joshua.pim.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends CrudRepository<Department, Long> {
    Iterable<Department> findByDepartID(Long departID);
}
