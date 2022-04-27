package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Grn;

/**Mahalakshmi**/

public interface GrnmainRepository extends JpaRepository<Grn, Integer>{

	@Query(value = "SELECT COUNT(Grnno) FROM medc_purchase.medc_grn where CompanyRefID=?1 AND Branchrefid=?2 AND LocName=?3 and LocRefID=?4 ", nativeQuery = true)
	Integer grnauto(int companyrefid, int branchrefid, int locname, int locrefid);

	
	

	@Query(value ="SELECT POID,PONO,vendorid,vendorname,status,vendorcode,podate,totalproduct,grandtotal,totalquantity,tax FROM medc_purchase.medc_purchaseorder where companyrefid = ?1 and BranchRefID = ?2 and locname = ?3 and locrefid = ?4 and status=2", nativeQuery = true)
    List purchaseorderpono(Integer comp, Integer brnch, Integer locname, Integer locrefid);



	


	@Query(value ="SELECT po.POID,po.PONO,po.vendorid,po.vendorname,po.status,po.vendorcode,po.podate,po.totalproduct,po.grandtotal,po.totalquantity,po.tax,di.MobileNo,di.PhoneNo FROM medc_purchase.medc_purchaseorder po INNER JOIN medc_distributor.medc_distributorinformation di  on po.vendorname = di.DistributorName  where poid = ?1 and status=2", nativeQuery = true)
    List findByPoid(Integer poid);


	@Query(value = "SELECT po.vendorcode,po.vendorname,po.VendorID,po.PONO,po.POID,po.`Status`,di.MobileNo,di.PhoneNo FROM medc_purchase.medc_purchaseorder po INNER JOIN medc_distributor.medc_distributorinformation di on po.vendorname = di.DistributorName where po.CompanyRefID=273 AND po.branchrefid=130 AND po.LocName=1 and po.LocRefID=128 ", nativeQuery = true)
    List viewgrnprocess(Integer comid, Integer branchid, Integer locname, Integer locrefid);






	
	
	

}
