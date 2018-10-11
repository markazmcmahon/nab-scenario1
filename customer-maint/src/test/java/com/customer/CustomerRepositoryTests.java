package com.customer;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void insertTest() {
        // given
        Customer customer = new Customer(null, "John", "Jack", "Smith", "JJ", "Mr",
                "100", "A", "Kew", "Melbourne", "Vic", "Australia", "3101",
                "M", "U", 99, true );
        testEntityManager.persist(customer);
        testEntityManager.flush();

        // when
        Optional<Customer> optCust = customerRepository.findById(customer.getId());
        Customer newCust = optCust.get();

        //then
        assertThat(newCust.getSurname()).isEqualTo(customer.getSurname());
    }

    @Test
    public void updateTest() {
        // given
        Customer customer = new Customer(null, "John", "Jack", "Smith", "JJ", "Mr",
                "100", "A", "Kew", "Melbourne", "Vic", "Australia", "3101",
                "M", "U", 99, true );
        testEntityManager.persist(customer);
        testEntityManager.flush();
        testEntityManager.detach(customer);

        Customer updatedCustomer = new Customer(1L, "Johnny", "Jacko", "Smith", "JJ", "Mr",
                "100", "A", "Kew", "Melbourne", "Vic", "Australia", "3101",
                "M", "U", 99, true );
        customerRepository.saveAndFlush(updatedCustomer);

        // when
        Optional<Customer> optCust = customerRepository.findById(customer.getId());
        Customer updCust = optCust.get();


        //then
        assertThat(updCust.getFirstName()).isNotEqualTo(customer.getFirstName());
    }

    @Test
    public void deleteTest() {
        // given
        Customer customer = new Customer(null, "John", "Jack", "Smith", "JJ", "Mr",
                "100", "A", "Kew", "Melbourne", "Vic", "Australia", "3101",
                "M", "U", 99, true );
        testEntityManager.persist(customer);
        testEntityManager.flush();

        // when
        customerRepository.deleteById(customer.getId());

        Optional<Customer> optCust = customerRepository.findById(customer.getId());

        //then
        assertThat(optCust.isPresent()).isFalse();
    }
}
