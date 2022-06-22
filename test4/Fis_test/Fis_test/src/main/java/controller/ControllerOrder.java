package controller;

import dto.OrderCartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repo.RepoOrderCart;
import service.impl.ImplOrderCart;
@RestController
@RequestMapping(path = "/api/page")
@Slf4j
public class ControllerOrder {
    private ImplOrderCart implOrderCart;
    @GetMapping(value = "/{page}/{size}}")
    public Page<OrderCartDTO> list(@PathVariable(name = "page")Integer page,
                                   @PathVariable(name = "size") Integer size ){
        log.info("request all ordercart page : {}, size: {}", page,size);
        return implOrderCart.findOrderCart(PageRequest.of(page,size));

    }

}
