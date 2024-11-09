package Service;

import Entity.Customer;
import IGeneric.IGeneral;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IGeneral<Customer> {
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer getById(String id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteById(String id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Customer> getAll() {
        return customers;
    }
}


