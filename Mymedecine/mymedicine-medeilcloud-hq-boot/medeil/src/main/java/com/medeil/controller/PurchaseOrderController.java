/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.PoProduct;
import com.medeil.domain.PurchaseOrder;
import com.medeil.service.PurchaseOrderService;

/**
 * @author Manikandan
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService PurchaseOrderService;

	@GetMapping(value = "distsessionurl/{cid}/{bid}")
	public List getSessionHospital(@PathVariable("cid") Integer cid, @PathVariable("bid") Integer bid)
			throws Exception {
		return PurchaseOrderService.getSessionHospital(cid, bid);
	}

	// get PurchaseOrder's Company
	@GetMapping(value = "/getPOrderCompany")
	public List getCompany() throws Exception {
		return PurchaseOrderService.getCompanies();
	}

	// @GetMapping(value = "/getPOAutoIncrements")
	// public List getAutoIncrments() throws Exception {
	// return PurchaseOrderService.getAutoincrement();
	// }

	// get PurchaseOrder's editCompany
	@GetMapping(value = "/getporderedit/{compid}/{brnchid}/{loc}/{locref}/{poid}")
	public List getEditPurchaseOrder(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locref, @PathVariable Integer poid) throws Exception {
		return PurchaseOrderService.getEditPurchaseOrder(compid, brnchid, loc, locref, poid);
	}

	// get PurchaseOrder's Branch
	@GetMapping(value = "/getPOrderBranch/{id}")
	public List getBranch(@PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getBranches(id);
	}

	// get PurchaseOrder's Branch
	@GetMapping(value = "/getPOrderWareHouse/{id}")
	public List getWareHouse(@PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getWareHouse(id);
	}

	// get PurchaseOrder's Branch
	@GetMapping(value = "/getPOrderHospitals/{id}")
	public List getHospitals(@PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getHospitals(id);
	}

	// get PurchaseOrder's Shop
	@GetMapping(value = "/getPOrderShop/{id}")
	public List getShops(@PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getShops(id);
	}

	// Boopalan 170419
	@GetMapping(value = "/getSuperDistributorProducts/{prsid}/{distID}")
	public List getSupeorDistributorProducts(@PathVariable Integer prsid, @PathVariable Integer distID)
			throws Exception {
		return PurchaseOrderService.getSuperDistributorProducts(prsid, distID);
	}

	@GetMapping(value = "/getDistributorProducts/{compid}/{brnchid}/{locname}/{locrefid}/{id}")
	public List getDistributorProducts(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getDistributorProducts(compid, brnchid, locname, locrefid, id);
	}

	/*
	 * @GetMapping(value = "/getDruginfo/{id}") public List
	 * getDrugData(@PathVariable Integer id) throws Exception { return
	 * PurchaseOrderService.getDrugData(id); }
	 */

	@GetMapping(value = "/getDruginfo/{id}/{compid}/{brnchid}/{locname}/{locrefid}/{vendorid}")
	public List getDrugData(@PathVariable Integer id, @PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer vendorid)
			throws Exception {
		return PurchaseOrderService.getDrugData(id, compid, brnchid, locname, locrefid, vendorid);
	}

	// get Purchase's Distributor
	@GetMapping(value = "/getSuperAdminPODistributor/{searchValue}")
	public List getSuperAdminDistributor(@PathVariable String searchValue) throws Exception {
		System.out.println("superadmin" + searchValue);
		return PurchaseOrderService.getSuperAdminDistributor(searchValue);
	}

	// get Purchase's Distributor
	@GetMapping(value = "/getPODistributor/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getDistributor(@PathVariable String searchValue, @PathVariable Integer compid,
			@PathVariable Integer brnchid, @PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return PurchaseOrderService.getDistributor(searchValue, compid, brnchid, loc, locref);
	}

	// get Purchase's Distributor
	@GetMapping(value = "/getPODistributoredit/{poid}")
	public List getDistributor(@PathVariable Integer poid) throws Exception {
		return PurchaseOrderService.getDistributorEdit(poid);
	}

	@GetMapping(value = "/getsuperdrugval/{searchValue}")
	public List getDrug(@PathVariable String searchValue) throws Exception {
		System.out.println("se" + searchValue);
		return PurchaseOrderService.getSuperDrug(searchValue);
	}

	@GetMapping(value = "/getdrugval/{searchValue}/{compid}/{brnchid}/{loc}/{locref}")
	public List getDrug(@PathVariable String searchValue, @PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return PurchaseOrderService.getDrug(searchValue, compid, brnchid, loc, locref);
	}

	// Create Purchase Order
	@PostMapping(value = "/createPurchaseOrder")
	public boolean createPurchaseOrder(@RequestBody PurchaseOrder purc) throws Exception {
		return PurchaseOrderService.createPurchaseOrder(purc);
	}

	// Create Purchase Order Product
	@PostMapping(value = "/createPurchaseOrderProduct")
	public List createPurchaseOrderProduct(@RequestBody List<PoProduct> purcpro) throws Exception {
		return PurchaseOrderService.createPurchaseOrderProduct(purcpro);
	}

	@PostMapping(value = "/updatePurchaseOrder")
	public boolean updatePurchaseOrder(@RequestBody PurchaseOrder purc) throws Exception {
		return PurchaseOrderService.updatePurchaseOrder(purc);
	}

	@PostMapping(value = "/updatePurchaseOrderProduct")
	public boolean updatePurchaseOrderProduct(@RequestBody List<PoProduct> purcpro) throws Exception {
		System.out.println("Table is calling");
		return PurchaseOrderService.updatePurchaseOrderProduct(purcpro);
	}

	// viewPurchaseOrder
	@GetMapping(value = "/viewpurchaseorder/{compid}/{brnchid}/{loc}/{locref}")
	public List viewPurchaseOrder(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return PurchaseOrderService.viewPurchaseOrder(compid, brnchid, loc, locref);
	}

	// EditPurchaseOrder
	@GetMapping(value = "/getPurchaseOrdersedit/{compid}/{brnchid}/{loc}/{locref}/{id}")
	public List getPurchaseOrder(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer loc,
			@PathVariable Integer locref, @PathVariable Integer id) throws Exception {
		return PurchaseOrderService.getPurchaseOrder(compid, brnchid, loc, locref, id);
	}

	@GetMapping(value = "/deletePurchaseOrder/{poid}")
	public Integer deletePurchaseOrder(@PathVariable Integer poid) throws Exception {
		// System.out.println("reutnr
		// :"+PurchaseOrderService.deletePurchaseOrder(poid));
		return PurchaseOrderService.deletePurchaseOrder(poid);
	}

	@GetMapping(value = "/viewindentstatusurl/{comp}/{brnch}/{loc}/{locref}")
	public List viewIndentStatus(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer loc,
			@PathVariable Integer locref) throws Exception {
		// System.out.println("comp"+"\t"+comp+"\t"+"brnch"+"\t"+brnch+"\t"+"loc"+"\t"+loc+"\t"+"locref"+"\t"+locref);
		return PurchaseOrderService.viewIndentStatus(comp, brnch, loc, locref);
	}

	@GetMapping(value = "/superadminviewindentstatusurl")
	public List superAdminViewIndentStatus() throws Exception {
		return PurchaseOrderService.superAdminViewIndentStatus();
	}

	@GetMapping(value = "/getuom/{companyid}/{branchid}/{locname}/{locrefid}")
	public List getPurchaseuom(@PathVariable Integer companyid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Inside currency");
		return PurchaseOrderService.getPurchaseuom(companyid, branchid, locname, locrefid);

	}

	@GetMapping(value = "/PurchaseOrderEmailDistributor/{did}")
	public List PurchaseOrderEmailDistributor(@PathVariable Integer did) throws Exception {
		return PurchaseOrderService.PurchaseOrderEmailDistributor(did);
	}

	// Get Minimum Quantity
	@GetMapping(value = "/getminimumqty/{cid}/{bid}/{lname}/{lrefid}")
	public List GetMinQty(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return PurchaseOrderService.GetMinQty(cid, bid, lname, lrefid);
	}

	// Get New Product
	@GetMapping(value = "/getnewpro/{cid}/{bid}/{lname}/{lrefid}")
	public List GetNewproduct(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return PurchaseOrderService.GetNewproduct(cid, bid, lname, lrefid);
	}

	// Get Zero Stock Product
	@GetMapping(value = "/getZerostkproduct/{cid}/{bid}/{lname}/{lrefid}")
	public List GetZerostockproduct(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return PurchaseOrderService.GetZerostockproduct(cid, bid, lname, lrefid);
	}

	@GetMapping(value = "/getcomnamedetails/{comp}/{brnch}/{locname}/{locrefid}")
	public List getnamedeatils(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {

		return PurchaseOrderService.namedetails(comp, brnch, locname, locrefid);
	}
	
	//Mahalakshmi viwe api 
	
	@GetMapping(value = "/purchaseprno/{comp}/{brnch}/{locname}/{locrefid}")
	public List purchaseprno(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return PurchaseOrderService.purchaseprno(comp, brnch, locname, locrefid);
	}
	
	//view product
		

	@GetMapping(value = "/viewPurchaseorderProductbyid/{porefid}")
	public ResponseEntity<?> viewPurchaseorderProductbyid(@PathVariable Integer porefid) {
		return PurchaseOrderService.viewPurchaseorderProductbyid(porefid);
	}
	
	//view main
	@GetMapping(value = "/viewPurchaseorderbyid/{id}")
	public ResponseEntity<?> viewPurchaseorderbyid(@PathVariable Integer id) {
		return PurchaseOrderService.viewPurchaseorderbyid(id);

	}

	@GetMapping(value = "/PoStatus/{suserid}")
	public ResponseEntity<?> PoStatus(@PathVariable Integer suserid) {
		return PurchaseOrderService.PoStatus(suserid);
		
	}
//Mahalakshmi status based api
	
	@GetMapping(value = "UpdatePoAcknowledge/{id}/{ackid}/{status}")
	public ResponseEntity<?> UpdatePoAcknowledge(@PathVariable Integer id, @PathVariable Integer ackid,@PathVariable Integer status) throws Exception {
		return PurchaseOrderService.UpdatePoAcknowledge(id, ackid,status);
	}
	
	@GetMapping(value = "UpdatePoApprove/{id}/{aprid}/{status}")
	public ResponseEntity<?> UpdatePoApprove(@PathVariable Integer id, @PathVariable Integer aprid,@PathVariable Integer status) throws Exception {
		return PurchaseOrderService.UpdatePoApprove(id, aprid,status);
	}

	@GetMapping(value = "UpdatePoRejected/{id}/{rejid}/{status}")
	public ResponseEntity<?> UpdatePoRejected(@PathVariable Integer id, @PathVariable Integer rejid,@PathVariable Integer status) throws Exception {
		return PurchaseOrderService.UpdateStatusRejected(id, rejid,status);
	}
	
	//mahalakshmi viewapi
	
	@GetMapping(value = "/ViewPurchaseOrder/{compid}/{brnchid}/{loc}/{locrefid}")
	public ResponseEntity<?> ViewPurchaseOrder(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid) throws Exception {
		return PurchaseOrderService.ViewPurchaseOrder(compid, brnchid, loc, locrefid);
	}
 
	//MAHALAKSHMI VIEW API MAIN TABLE
	@GetMapping(value = "/viewPurchaseOrderid/{id}")
	public ResponseEntity<?> viewPurchaseOrderid(@PathVariable Integer id) {
		return PurchaseOrderService.viewPurchaseOrderid(id);

	}
	// MAHALAKSHMI VIEW API PRODUCT TABLE
	@GetMapping(value = "/viewPoProductid/{porefid}")
	public ResponseEntity<?> viewPoProductid(@PathVariable Integer porefid) {
		return PurchaseOrderService.viewPoProductid(porefid);

	}
	// Mahalakshmi edit api
	@GetMapping(value = "/getpurchaseorder/{poid}")
	public ResponseEntity<?> getpurchaseorder(@PathVariable Integer poid ) {
		return PurchaseOrderService.getpurchaseorder(poid);

	}
	//mahalakshmi edit api for product table
	
	@GetMapping(value = "/GetpurchaseorderProductid/{poid}")
	public ResponseEntity<?> GetpurchaseorderProductid(@PathVariable Integer poid) {
		return PurchaseOrderService.GetpurchaseorderProductid(poid);

	}
	
	// mahalakshmi delete api
	
	@GetMapping(value = "/deletePurchaseorderproduct/{id}")
	public ResponseEntity<?> deletePurchaseorderproduct(@PathVariable Integer id) throws Exception {
		return PurchaseOrderService.deletePurchaseorderproduct(id);
	}

	// view api for multiple po
	@GetMapping(value = "/viewid/{id}")
	public ResponseEntity<?> viewid(@PathVariable Integer id) {
		return PurchaseOrderService.viewid(id);

	}
	
	}
	
