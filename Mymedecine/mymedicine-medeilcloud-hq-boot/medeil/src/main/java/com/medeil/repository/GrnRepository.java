 package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Drug;
import com.medeil.domain.Grn;
import com.medeil.domain.Grnproduct;

@Repository
public interface GrnRepository extends JpaRepository<Grnproduct, Integer>{

//Mahalakshmi

@Query(value = "SELECT BatchID  from medc_stock.medc_drugbatch WHERE CompanyRefID=?1 and DrugProductRefID=?2 and Batchno=?3", nativeQuery = true)
	Integer getbatchid(Integer companyrefid, Integer drugproductrefid, String batchno);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO medc_stock.medc_drugbatch(CompanyRefID,DrugProductRefID,BatchNo) values (?1,?2,?3)", nativeQuery = true)
	void insertbatchid(Integer companyrefid, Integer drugproductrefid, String batchid);
	
	@Modifying
	@Transactional
	@Query(value = "update medc_purchase.medc_poproduct set piflag=1 where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4 and porefid=?5 and drugproductrefid=?6", nativeQuery = true)
	void getupdateflag(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid, Integer refpoid,Integer drugproductrefid);
	


	Grnproduct findByPirefidAndDrugproductrefid(Integer valueOf, Integer valueOf2);
	@Query(value = "SELECT PIID, PINO FROM medc_purchase.medc_purchaseinvoice  WHERE Status=0 and CompanyRefID= :cid and BranchRefID= :bid and LocName= :locname and LocRefid= :locrefid", nativeQuery = true)
	List getPurchaseInvoiceList(@Param("cid") int cid, @Param("bid") int bid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	/** GET EDIT POID PURCHASE INVOICE **/ // venkat
	@Query(value = "SELECT m.poid,m.pono FROM medc_purchase.medc_purchaseorder m inner join medc_purchase.medc_purchaseinvoice pi on pi.refpoid = m.poid where m.Status=0 and piid=:piids", nativeQuery = true)
	List getpoidpi(@Param("piids") int piids);

	@Query(value = "SELECT   IFNULL(  max( piid ) ,0 )  FROM   medc_purchase.medc_purchaseinvoice   where   LocName=?1 and LocRefID=?2", nativeQuery = true)
	int viewPurchaseInvoiceId(Double lcrnm, Double lcrid);
	
	@Query(value = "select pi.pino from medc_purchase.medc_purchaseinvoice pi join(select max(piid) as maxid from medc_purchase.medc_purchaseinvoice where LocName=?1 and LocRefID=?2) pid on pid.maxid = pi.piid ", nativeQuery = true)
	String viewPurchaseInvoiceMaxNo(Double lcrnm, Double lcrid);
	
	@Query(value = "SELECT distributorname FROM medc_distributor.medc_distributorinformation where distributorid =?1", nativeQuery = true)
	String viewCustName(Integer id);
	
	
	 @Query(value="Select coalesce(MAX(pino),'PIV000000000') from medc_purchase.medc_purchaseinvoice where companyrefid=?1 and branchrefid=?2 and locname=?3 and locrefid=?4",nativeQuery = true)
	String lastPurchaseInvoice(Integer companyrefid, Integer branchrefid, Integer locname, Integer locrefid);

	@Query(value = "SELECT dcid,dist_dcno,dist_invno FROM medc_stock.medc_deliverchallan where companyrefid =?1 and branchrefid =?2 and locname =?3 and locrefid =?4 and poid =?5", nativeQuery = true)
	 List getdistdc(Integer cmpid, Integer brnchid, Integer lname, Integer lrefid, Integer poid);

	@Query(value = "SELECT pr.ProductDrugID,concat(pr.BrandName,'',IFNULL(pr.GenericNameDosage,'-'),'',IFNULL(fr.FormulationName,'-')) productname,fr.FormulationName,CONCAT(pr.GenericNameDosage,coalesce(pr.UOM,''))as DosageValue,ph.pshortname,coalesce(stk.MRP,0),pr.FormulationID,\r\n" + 
			"			pr.PharmaCompanyID as mfg,dcpro.BoxQty,dcpro.StripQty,dcpro.TabQty,coalesce(po.UnitPrice,0),po.Discount,pr.VAT,pr.GST,pr.SGST,pr.CGST,pr.IGST,pr.UTGST,date(dcpro.expirydate),dcpro.batchname,coalesce(hsn.hsncode,'NA'),hsn.hsnid,dcpro.stripperbox,dcpro.quantityperstrip,dcpro.totalqty,\r\n" + 
			"      coalesce(stk.sellingprice,0),dcpro.packageunit\r\n" + 
			"			from medc_stock.medc_dchallanproduct dcpro\r\n" + 
			"			inner join medc_productmaster.medc_custproductmaster pr on pr.ProductDrugID = dcpro.drugproductrefid\r\n" + 
			"			inner join medc_purchase.medc_poproduct po on po.porefid = dcpro.poid\r\n" + 
			"			inner join medc_productmaster.medc_formulation fr on fr.FormulationID = pr.FormulationID\r\n" + 
			"			left join medc_productmaster.medc_hsncodemaster hsn on hsn.hsnid = pr.hsnid\r\n" + 
			"			left join medc_pharmacompany.medc_pharmacompanies ph on ph.pcompanyid = pr.PharmaCompanyID\r\n" + 
			"      left join  medc_stock.medc_mainstock stk on stk.drugproductid = pr.productdrugid where dcpro.poid =?1 and dcpro.dcrefid =?2 group by pr.productdrugid",nativeQuery = true)
	List getdcproducts(Integer poid, Integer dcrefid);

	
	@Query(value = "SELECT hsnid,hsncode,gst FROM medc_productmaster.medc_hsncodemaster where chapter = 30", nativeQuery = true)
	List getHsncodelist();
	
	
	@Query(value = "SELECT * from medc_purchase.medc_grnproduct", nativeQuery = true)
    List<Grnproduct> findByCompanyrefidAndBranchidAndLocnameAndLocrefidAndPoid(Integer compid, Integer brnchid,
			Integer loc, Integer locrefid, Integer poid);



	
	
	

	

}

