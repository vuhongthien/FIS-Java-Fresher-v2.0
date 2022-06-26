package com.m6.javadevjournal.springbooth2.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.LockModeType;

import com.m6.javadevjournal.springbooth2.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long>,
		ModelJpaRepositoryCustom {

	//Write DSL
	List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	List<Model> findByModelTypeNameIn(List<String> types);

	//@Query && JPQL
	@Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
	Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest,
											 @Param("highest") BigDecimal high,
											 @Param("wood") String wood,
											 Pageable page);


	//@NamedQuery in Model Entity
	List<Model> findAllModelsByType(@Param("name") String name);
}
