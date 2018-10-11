package com.customer.controller;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "customers", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    public Optional<Customer> get(@PathVariable Long id) {
        return customerRepository.findById(id);
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.PUT)
    public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        BeanUtils.copyProperties(customer, existingCustomer);
        return customerRepository.saveAndFlush(customer);
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.DELETE)
    public Optional<Customer> delete(@PathVariable Long id) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        customerRepository.deleteById(id);
        return existingCustomer;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Customer> list() {
        return customerRepository.findAll();
    }
}
