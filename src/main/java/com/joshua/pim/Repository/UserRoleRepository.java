package com.joshua.pim.Repository;

import com.joshua.pim.Model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository  extends CrudRepository<UserRole, Long> {

    Iterable<UserRole> findByUserroleID(Long userroleID);
}
