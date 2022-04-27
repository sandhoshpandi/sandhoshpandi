package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.PurchaseRequisitionProduct;

@Repository
public interface PurchaseRequisitionProductRepo extends JpaRepository<PurchaseRequisitionProduct, Integer> {

	@Query(value = "SELECT * from medc_purchase.medc_purchaserequisitionproduct pr where pr.purcreqnoref=?1 and status!=5", nativeQuery = true)
	List<PurchaseRequisitionProduct> findByPurcreqnoref(Integer purcreqnoref);
	
	
	//Mahalakshmi
	
	@Query(value = "SELECT s3.*  from medc_purchase.medc_purchaserequisitionproduct s3 INNER JOIN medc_purchase.medc_purchaserequisition s on s.purcreqno=s3.purcreqnoref WHERE s3.purcreqnoref=55 and s3.productid not in (SELECT s2.DrugProductRefID from medc_purchase. medc_purchaseorder s1 INNER JOIN medc_purchase.medc_poproduct s2 on s2.PORefID=s1.POID INNER JOIN medc_purchase.medc_purchaserequisitionproduct pr on pr.purcreqnoref=s1.prno where s3.purcreqnoref=55) and s.`status` != 5", nativeQuery = true)
    List<PurchaseRequisitionProduct> findByPurcreqnorefandprno(Integer purcreqnoref);
	

//Mahalakshmi reqstatus
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaseRequisitionProduct SET reqstatus= '2' WHERE purcreqprodid = ?1", nativeQuery = true)
	Integer dlreqstatus(@Param("purcreqprodid")int purcreqprodid);
	
	
}
