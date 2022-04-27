package com.medeil.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Branch;
import com.medeil.domain.PurchaseRequisition;

@Repository
public interface PurchaseRequisitionRepository extends JpaRepository<PurchaseRequisition, Integer> {

	
	@Query(value = " SELECT * from medc_purchase.medc_purchaserequisition pr where pr.companyrefid=?1  and pr.branchid=?2   and pr.locname=?3   and pr.locrefid=?4 and status!=5 and status != 2", nativeQuery = true)
	List<PurchaseRequisition> findByCompanyrefidAndBranchidAndLocnameAndLocrefid(Integer compid, Integer brnchid,
			Integer loc, Integer locrefid);

	@Query(value = " SELECT EmployeeID,concat(emp.EmpFirstName,' ',emp.EmpLastName) as EmployeeName from  medc_employee.medc_employeedetails emp INNER JOIN medc_adminsecurity.medc_role ro on emp.CompanyID=ro.CompanyID where ro.RoleID=?1", nativeQuery = true)
	List getemplist(int roleid);

//	@Query(value = "select cu.ProductDrugID,cu.BrandName,SUM(mm.qty) as balance  from medc_productmaster.medc_custproductmaster cu INNER JOIN medc_stock.medc_mainstock mm on cu.ProductDrugID=mm.DrugProductID  where cu.companyID=?1 and cu.BranchID=?2 and cu.LocName=?3 and cu.LocRefID=?4 and cu.ProductDrugID=?5", nativeQuery = true)
	@Query(value = "select cu.ProductDrugID,cu.BrandName,SUM(mm.qty) as balance,SUM(mn.TotalQty)  from medc_productmaster.medc_custproductmaster cu INNER JOIN medc_stock.medc_mainstock mm on cu.ProductDrugID=mm.DrugProductID INNER JOIN medc_sales.medc_salesmaintenance mn on mn.CompanyRefID=cu.companyID INNER JOIN medc_sales.medc_salesbill bi on bi.DrugProductID=cu.ProductDrugID where  mn.SalesBillID=bi.SalesRefID and cu.companyID=?1 and cu.BranchID=?2 and cu.LocName=?3 and cu.LocRefID=?4 and cu.ProductDrugID=?5  and   mn.ClientCDate BETWEEN (CURRENT_DATE() - INTERVAL 1 MONTH) AND CURRENT_DATE()", nativeQuery = true)
	List getstockbalance(Integer cid, Integer bid, Integer lname, Integer lrefid, Integer prodid);

	@Query(value = "SELECT COUNT(purcreqno) FROM medc_purchase.medc_purchaserequisition where CompanyRefID=?1 AND branchid=?2 AND LocName=?3 and LocRefID=?4 ", nativeQuery = true)
	Integer reqauto(Integer companyrefid, Integer branchid, Integer locname, Integer locrefid);

	List<PurchaseRequisition> findByIdAndAcknowledgedbyuseridAndStatus(Integer id, Integer ackbyuserid, Integer status);

	PurchaseRequisition findAllByIdAndAcknowledgedbyuseridAndStatus(Integer id, Integer ackbyuserid, Integer status);

	List<PurchaseRequisition> findAllByAcknowledgedbyuseridAndStatus(Integer userid, Integer status);

	@Query(value = "SELECT dis.distributorid,dis.distributorname,dis.vendorcode,dis.taxstatus,dis.DistNo FROM medc_distributor.medc_distributorinformation dis\r\n"
			+ "Where dis.companyrefid=?1 and dis.branchrefid=?2 and dis.locname=?3 and dis.locrefid=?4  ", nativeQuery = true)
	List vendlist(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("lnid") Integer lnid,
			@Param("lrid") Integer lrid);

	void save(List<PurchaseRequisition> pr);

	
	@Query(value = "SELECT * from medc_purchase.medc_purchaserequisition pr LEFT JOIN medc_purchase.medc_purchaserequisitionproduct rp on pr.purcreqno=rp.purcreqnoref where rp.purcreqprodid=?1", nativeQuery = true)
	Optional<PurchaseRequisition> getPurcReqId(Integer prprodid);

	List<PurchaseRequisition> findAllByAcknowledgedbyAndStatus(String acknowledgeby, Integer status);

	@Query(value = "select br.BranchID,br.Branchname,br.Contactperson,br.Desgination,br.MobileNo,br.PhoneNo, CONCAT(br.Address1,br.Address2),br.City,br.Pincode,br.Country,br.Countrycode from medc_branchreg.medc_branchinfomation br where br.CompanyRefID=?1 and br.locname=?2", nativeQuery = true)
	List warehousedropdown(Integer cid,Integer loc);

	
	@Query(value = "SELECT pr.purcreqno,pr.purchasereqid,pr.requestedby,pr.requesteddate,pr.requestedarea,pr.createddate,pr.companyrefid,pr.branchid,pr.locname,pr.locrefid,pr.vendorid,pr.vendorcode,pr.vendorname,pr.`status`,pr.acknowledgedbyuserid,ad.employeeid,ad.purmorefid,ad.prevacstatus,ad.roleranking,ad.suserid from medc_purchase.medc_purchaserequisition pr  INNER JOIN medc_adminsecurity.medc_adduserpurchaseprev ad on ad.companyrefid=pr.companyrefid where pr.companyrefid=?1 and pr.branchid=?2 and pr.locname=?3 and pr.locrefid=?4", nativeQuery = true)
	List getpurReqwithstatus(Integer compid, Integer brnchid, Integer loc, Integer locrefid);

	
	@Query(value = "select ad.prevacstatus from medc_adminsecurity.medc_adduserpurchaseprev ad where ad.purmorefid=1 and ad.suserid=?1", nativeQuery = true)
	Integer RequisitionStatus(Integer suserid);

	
	@Query(value = "SELECT * from medc_purchase.medc_purchaserequisition pr where pr.purcreqno=?1", nativeQuery = true)
	PurchaseRequisition getById(Integer acknowledgedbyid);

	
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_purchase.medc_purchaserequisition SET reqstatus= '2' WHERE purcreqno = ?1", nativeQuery = true)
	Integer dlreqstatus(@Param("purcreqno")int purcreqno);

	
	
	
	

}
