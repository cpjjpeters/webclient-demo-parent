package ipeters.address;

import ipeters.webclient_demo_address_service.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(
            nativeQuery = true,
            value
                    = "SELECT ea.id, ea.city, ea.state FROM address ea join employee e on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);

//    public Optional<Address> findAddressByEmployeeId(@Param("employeeId") int employeeId);
}