package vn.fis.training.service;

import vn.fis.training.domain.Customer;
import vn.fis.training.exception.CustomerNotFoundException;
import vn.fis.training.exception.DuplicateCustomerException;
import vn.fis.training.exception.InvalidCustomerException;
import vn.fis.training.exception.InvalidCustomerStatusException;
import vn.fis.training.store.InMemoryCustomerStore;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCustomerService implements CustomerService{

    private InMemoryCustomerStore customerStore;

    @Override
    public Customer findById(String id) throws CustomerNotFoundException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if (isNullOrEmpty(id)){
            throw new IllegalArgumentException("khong tìm kiem id duoc");
        }
        customerStore.findAll().stream().filter(customer -> {
            return id.equals(customer.getId());
        }).findFirst().orElseThrow(()->{
            throw new CustomerNotFoundException(
                    String.format("Khong tìm thấy customer với id là %s",id));
        });
        return null;

    }
    private  boolean isNullOrEmpty(String id ){
        if(id==null) return false;
        if (id.trim().length()==0) return false;
        return true;
    }

    @Override
    public Customer createCustomer(Customer customer) throws InvalidCustomerException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        validate(customer);
        checkDuplicate(customer);
        return customerStore.insertOrUpdate(customer);        
    }

    private void checkDuplicate(Customer customer) {
        if(customerStore.findAll().stream().filter(customer1 -> {
            return customer1.getMobile().equals(customer.getMobile());
        }).findFirst().isPresent()){
            throw  new DuplicateCustomerException(customer,
                    String.format("đã có sdt %s trong dữ liệu",customer.getMobile()));
        }
    }

    private void validate(Customer customer) {
        if(isNullOrEmpty(customer.getName())){
            throw  new InvalidCustomerException(customer,"Custommer name is empty");
        }
        if(isNullOrEmpty(customer.getMobile())){
            throw  new InvalidCustomerException(customer,"Custommer MObile is empty");
        }
        
    }


    @Override
    public Customer updateCustomer(Customer customer) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        validate(customer);
        findById(customer.getId());
        return customerStore.insertOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(String id)  throws InvalidCustomerStatusException {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        if(isNullOrEmpty(id)){
            throw new IllegalArgumentException("can not delete with empty id");
        }
        findById(id);
        customerStore.deleteById(id);
    }

    @Override
    public List<Customer> findAllOrderByNameAsc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllOrderByNameLimit(int limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getName))
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findAllCustomerByNameLikeOrderByNameAsc(String custName, String limit) {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .filter(s->s.getName().startsWith(custName))
                .sorted(Comparator.comparing(Customer::getName))
                .limit(Long.parseLong(limit))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> summaryCustomerByAgeOrderByAgeDesc() {
        //TODO: Implement method tho dung dac ta cua CustomerService interface
        return customerStore.findAll().stream()
                .sorted(Comparator.comparing(Customer::getBirthDay).reversed())
                .collect(Collectors.toList());
    }

}
