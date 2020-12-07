package com.joshua.pim.Repository;

import com.joshua.pim.Model.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Long> {
    Iterable<Roles> findByRoleID(Long roleID);
}
