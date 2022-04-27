package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.PurchaseRequisition;
import com.medeil.domain.PurchaseRequisitionProduct;
import com.medeil.service.PurchaseRequisitionService;
import com.medeil.service.RoleService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PurchaseRequisitionController {
	@Autowired
	private PurchaseRequisitionService PurchaseReqService;

	
	@GetMapping(value = "getroleidrolename/{compid}")
	public ResponseEntity<?> getRoleidRolename(@PathVariable Integer compid) throws Exception {
		return PurchaseReqService.getRoleidRolename(compid);
	}

	@GetMapping(value = "getemplist/{roleid}")
	public ResponseEntity<?> getemplist(@PathVariable Integer roleid) throws Exception {
		return PurchaseReqService.getemplist(roleid);
	}

	// get getstockbalance/consumption qty/prodcutcode/product name
	@GetMapping(value = "getstockbalance/{cid}/{bid}/{lname}/{lrefid}/{prodid}")
	public List getstockbalance(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid, @PathVariable Integer prodid) throws Exception {
		return PurchaseReqService.getstockbalance(cid, bid, lname, lrefid, prodid);
	}
	
	
	//get warehouse dropdown api
	@GetMapping(value = "warehousedropdown/{cid}/{loc}")
	public ResponseEntity<?> warehousedropdown(@PathVariable Integer cid,@PathVariable Integer loc) throws Exception {
		return PurchaseReqService.warehousedropdown(cid,loc);
	}

	// editreqform based userid, status based
	@PostMapping(value = "/editreqform")
	public ResponseEntity<Boolean> editreqform(@RequestBody PurchaseRequisition pr) throws Exception {
		return PurchaseReqService.editreqform(pr);
	}

	@GetMapping(value = "/vendlist/{cid}/{bid}/{lnid}/{lrid}")
	public List vendlist(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lnid,
			@PathVariable Integer lrid) throws Exception {
		System.out.println("DistSearch");
		return PurchaseReqService.vendlist(cid, bid, lnid, lrid);

	}
	
	
	@PostMapping(value = "/createPurchaseRequisition")
	public ResponseEntity<Boolean> createPurchaseReq(@RequestBody PurchaseRequisition pr) throws Exception {
		return PurchaseReqService.createPurchaseReq(pr);
	}

	@PostMapping(value = "/createPurchaseRequisitionproduct")
	public ResponseEntity<Boolean> createPurchaseReqProduct(@RequestBody List<PurchaseRequisitionProduct> pr)
			throws Exception {
		return PurchaseReqService.createPurchaseReqProduct(pr);
	}

	@PostMapping(value = "/updatePurchaseRequisition")
	public ResponseEntity<Boolean> updatePurchaseReq(@RequestBody PurchaseRequisition pr) throws Exception {
		return PurchaseReqService.updatePurchaseReq(pr);
	}
	
	@PostMapping(value = "/updatePurchaseRequisitionProduct")
	public ResponseEntity<Boolean> updatePurchaseReqProduct(@RequestBody List<PurchaseRequisitionProduct> prp) throws Exception {
		return PurchaseReqService.updatePurchaseReqProduct(prp);
	}

	@GetMapping(value = "/deletePurchaseRequisition/{id}")
	public ResponseEntity<?> deletePurchaseReq(@PathVariable Integer id) throws Exception {
		return PurchaseReqService.deletePurchaseReq(id);
	}
	
	//delete one purchasereq request all products based on purrefno, error need to resolve
//	@GetMapping(value = "/deleteonePreqallProd/{Purcreqnoref}")
//	public ResponseEntity<?> deleteonePreqallProd(@PathVariable Integer Purcreqnoref) throws Exception {
//		return PurchaseReqService.deleteonePreqallProd(Purcreqnoref);
//	}
	
	
	@GetMapping(value = "/deletePurchaseRequisitionproduct/{id}")
	public ResponseEntity<?> deletePurchaseReqProduct(@PathVariable Integer id) throws Exception {
		return PurchaseReqService.deletePurchaseReqProduct(id);
	}

	@GetMapping(value = "/ViewPurchaseRequisition/{compid}/{brnchid}/{loc}/{locrefid}")
	public ResponseEntity<?> ViewPurchaseRequisition(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid) throws Exception {
		return PurchaseReqService.ViewPurchaseRequisition(compid, brnchid, loc, locrefid);
	}

	//view preq,produtcs  based id 
	@GetMapping(value = "/viewPurchaseReqbyid/{id}")
	public ResponseEntity<?> viewPurchaseReqbyid(@PathVariable Integer id) {
		return PurchaseReqService.viewPurchaseReqbyid(id);

	}
	
	@GetMapping(value = "/viewPurchaseProductReqbyid/{Purcreqnoref}")
	public ResponseEntity<?> viewPurchaseReqProdbyid(@PathVariable Integer Purcreqnoref) {
		return PurchaseReqService.viewPurchaseReqProdbyid(Purcreqnoref);

	}
	
	
	@GetMapping(value = "/RequisitionStatus/{suserid}")
	public ResponseEntity<?> RequisitionStatus(@PathVariable Integer suserid) {
		return PurchaseReqService.RequisitionStatus(suserid);

	}

	// get only single product editpage purchasereq details and product detail
	@GetMapping(value = "/GetPurcReqEditpagebyid/{prprodid}")
	public ResponseEntity<?> GetPurcReqEditpagebyid(@PathVariable Integer prprodid) {
		return PurchaseReqService.GetPurcReqEditpagebyid(prprodid);

	}
	
	@GetMapping(value = "/GetPurcReqProductEditpagebyid/{prprodid}")
	public ResponseEntity<?> GetPurcReqProductEditpagebyid(@PathVariable Integer prprodid) {
		return PurchaseReqService.GetPurcReqProductEditpagebyid(prprodid);

	}

	//company all users status based requisitions form view 
	@GetMapping(value = "/viewRequisition/{userid}/{status}")
	public ResponseEntity<?> viewRequisition(@PathVariable Integer userid, @PathVariable Integer status) {
		return PurchaseReqService.viewRequisition(userid, status);

	}
	//individualrequestedlist for acknowledge person
	//acknowledgeby and status
	@GetMapping(value = "/AcknowledgerGetReq/{acknowledgeby}/{status}")
	public ResponseEntity<?> AcknowledgerGetReq(@PathVariable String acknowledgeby, @PathVariable Integer status) {
		return PurchaseReqService.AcknowledgerGetReq(acknowledgeby, status);

	}
	
	//company status based requisitions total products view 
	@GetMapping(value = "/viewReqProdstatusBase/{userid}/{status}/{Purcreqnoref}")
	public ResponseEntity<?> viewReqProdstatusBase(@PathVariable Integer userid, @PathVariable Integer status,@PathVariable Integer Purcreqnoref) {
		return PurchaseReqService.viewReqProdstatusBase(userid, status,Purcreqnoref);

	}
   // one userid can create more requisition form, to identify one req of multirequistion 
	@GetMapping(value = "getRequisitionByuserid/{purcreqno}/{userid}/{status}")
	public ResponseEntity<?> getRequisitionByuserid(@PathVariable Integer purcreqno, @PathVariable Integer userid,
			@PathVariable Integer status) throws Exception {
		return PurchaseReqService.getRequisitionByuserid(purcreqno, userid, status);
	}
	
	@GetMapping(value = "UpdateStatusAsAcknowledge/{id}/{ackbyuserid}/{status}")
	public ResponseEntity<?> UpdateStatusAsAcknowledge(@PathVariable Integer id, @PathVariable Integer ackbyuserid,
			@PathVariable Integer status) throws Exception {
		return PurchaseReqService.UpdateStatusAsAcknowledge(id, ackbyuserid, status);
	}

	// sound 
	@GetMapping(value = "UpdateStatusAcknowledge/{id}/{ackid}/{status}")
	public ResponseEntity<?> UpdateStatusAcknowledge(@PathVariable Integer id, @PathVariable Integer ackid,@PathVariable Integer status) throws Exception {
		return PurchaseReqService.UpdateStatusAcknowledge(id, ackid,status);
	}
	
	@GetMapping(value = "UpdateStatusApprove/{id}/{aprid}/{status}")
	public ResponseEntity<?> UpdateStatusApprove(@PathVariable Integer id, @PathVariable Integer aprid,@PathVariable Integer status) throws Exception {
		return PurchaseReqService.UpdateStatusApprove(id, aprid,status);
	}

	@GetMapping(value = "UpdateStatusRejected/{id}/{rejid}/{status}")
	public ResponseEntity<?> UpdateStatusRejected(@PathVariable Integer id, @PathVariable Integer rejid,@PathVariable Integer status) throws Exception {
		return PurchaseReqService.UpdateStatusRejected(id, rejid,status);
	}
	
	  //status based single  requisition product get api for edit page /need to resolve 
//	@GetMapping(value = "viewReqSingleProd/{purcreqprodid}/{userid}/{status}")
//	public ResponseEntity<?> viewReqSingleProd(@PathVariable Integer purcreqprodid, @PathVariable Integer userid,
//			@PathVariable Integer status) throws Exception {
//		return PurchaseReqService.viewReqSingleProd(purcreqprodid, userid, status);
//	}
	//mahalakshmi
	
	/*@GetMapping(value = "/viewPurchaseProductbyid/{Purcreqnoref}")
	public List viewPurchaseProductbyid(@PathVariable Integer Purcreqnoref) {
		return PurchaseReqService.viewPurchaseProductbyid(Purcreqnoref);

	}*/
	
//mahalakshmi
	@GetMapping(value = "/viewPoProductbyid/{Purcreqnoref}")
	public ResponseEntity<?> viewPoProductbyid(@PathVariable Integer Purcreqnoref) {
		return PurchaseReqService.viewPoProductbyid(Purcreqnoref);

	}
// Mahalakshmi delete api
	
	@GetMapping(value = "/dlreqstatus/{purcreqprodid}")
	public Integer dlreqstatus(@PathVariable Integer purcreqprodid) throws Exception {
		
		return PurchaseReqService.dlreqstatus(purcreqprodid);
	}
	

}
