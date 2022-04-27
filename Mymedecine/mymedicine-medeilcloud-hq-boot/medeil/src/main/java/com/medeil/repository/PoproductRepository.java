package com.medeil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PoProduct;
import com.medeil.domain.PurchaseOrder;

/**Mahalakshmi*/

@Repository
public interface PoproductRepository extends JpaRepository<PoProduct, Integer>{

	Optional<PoProduct> findByPorefidAndDrugproductrefid(Integer refpoid, Integer drugproductrefid);

	@Query(value = "SELECT * from medc_purchase.medc_poproduct where porefid = ?1 and status!=5", nativeQuery = true)
    List<PoProduct> findByPorefid(Integer porefid);
	
	
	
	@Query(value = "SELECT m.* from medc_purchase.medc_purchaseorder m LEFT JOIN medc_purchase.medc_poproduct n on m.poid = n.porefid where m.poid = ?1", nativeQuery = true)
    List getPono(Integer poid);

}
