package com.joshua.pim.Repository;
import com.joshua.pim.Model.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {
    Iterable<Customers> findByCustomerID(Long customerID);

}
