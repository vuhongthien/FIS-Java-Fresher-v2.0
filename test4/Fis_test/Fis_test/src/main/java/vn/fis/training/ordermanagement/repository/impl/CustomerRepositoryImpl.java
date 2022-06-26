package vn.fis.training.ordermanagement.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import vn.fis.training.ordermanagement.model.Order;
import vn.fis.training.ordermanagement.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private DataSource dataSource;

    public CustomerRepositoryImpl(EntityManager entityManager,DataSource dataSource) {
        this.entityManager = entityManager;
        this.dataSource = dataSource;
    }

    @Override
    public List<Order> findAllOrdersUsingCustomerRepository() {
        return entityManager.createQuery("select o from Order o").getResultList();
    }
}
