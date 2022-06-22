package service.impl;

import dto.OrderCartDTO;
import lombok.extern.slf4j.Slf4j;
import model.OrderCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repo.RepoOrderCart;
import service.InterfaceOrderCart;
@Service
@Slf4j
public class ImplOrderCart implements InterfaceOrderCart {
    private RepoOrderCart repoOrderCart;
    @Autowired
    public  ImplOrderCart(RepoOrderCart repoOrderCart) {
        this.repoOrderCart = repoOrderCart;
    }

    @Override
    public Page<OrderCartDTO> findOrderCart(Pageable pageable) {
        log.info("Query all Order. ",pageable.getPageNumber(),pageable.getPageSize());
        return repoOrderCart.findAll(pageable).map(OrderCartDTO.Mapper ::fromEmtity);
    }
}
