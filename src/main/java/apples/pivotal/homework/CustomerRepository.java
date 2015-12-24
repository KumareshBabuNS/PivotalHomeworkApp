package apples.pivotal.homework;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pasapicella on 24/12/15.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
}
