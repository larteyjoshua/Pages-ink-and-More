package com.joshua.pim.Repository;

import com.joshua.pim.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
        Iterable<Users> findByUserID(Long UserID);
        Optional<Users> findByEmail(String email);
      //  Optional<Users> findByUserName(String userName);
}
