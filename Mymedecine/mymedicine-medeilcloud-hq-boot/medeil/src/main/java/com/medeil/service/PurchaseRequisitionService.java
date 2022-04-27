package com.medeil.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Branch;
import com.medeil.domain.PurchaseRequisition;
import com.medeil.domain.PurchaseRequisitionProduct;
import com.medeil.domain.Role;
import com.medeil.domain.User;
import com.medeil.repository.PurchaseRequisitionProductRepo;
import com.medeil.repository.PurchaseRequisitionRepository;
import com.medeil.repository.RoleRepository;
import com.medeil.repository.UserRepository;

@Service
public class PurchaseRequisitionService {
	@Autowired
	private PurchaseRequisitionRepository PurchaseReqrepo;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PurchaseRequisitionProductRepo productRepo;
	int purchaseid;
	int updatepurchaseid;

	public ResponseEntity<Boolean> createPurchaseReq(PurchaseRequisition pr) {
		Integer reqauto = PurchaseReqrepo.reqauto(pr.getCompanyrefid(), pr.getBranchid(), pr.getLocname(),
				pr.getLocrefid());
		String REQcode = String.format("%04d", (reqauto + 1));
		String REQ = "PREQ" + REQcode;
		System.out.println("PREQ___________ " + REQ);
		pr.setPurchasereqid(REQ);
		purchaseid = PurchaseReqrepo.save(pr).getId();

		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> deletePurchaseReq(Integer id) throws Exception {
		PurchaseRequisition pr=PurchaseReqrepo.findById(id).get();
		pr.setStatus(5);
		PurchaseReqrepo.save(pr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> updatePurchaseReq(PurchaseRequisition pr) {
		PurchaseReqrepo.save(pr);
		updatepurchaseid = PurchaseReqrepo.save(pr).getId();
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> ViewPurchaseRequisition(Integer compid, Integer brnchid, Integer loc, Integer locrefid) {
//		List reqInfo=PurchaseReqrepo.getpurReqwithstatus(compid,brnchid,loc,locrefid);
		List<PurchaseRequisition> li = PurchaseReqrepo.findByCompanyrefidAndBranchidAndLocnameAndLocrefid(compid,
				brnchid, loc, locrefid);
		return ResponseEntity.created(null).body(li);
	}

	public ResponseEntity<?> viewPurchaseReqbyid(Integer id) {
		// TODO Auto-generated method stub
		Optional<PurchaseRequisition> pr = PurchaseReqrepo.findById(id);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> viewRequisition(Integer userid, Integer status) {
		List<PurchaseRequisition> li = PurchaseReqrepo.findAllByAcknowledgedbyuseridAndStatus(userid, status);
		return ResponseEntity.created(null).body(li);
	}

	public ResponseEntity<?> getRoleidRolename(Integer compid) throws Exception {
		List<Role> ro = roleRepository.findByCompanyid(compid);
		return ResponseEntity.created(null).body(ro);

	}

	public ResponseEntity<?> getemplist(Integer roleid) throws Exception {

		List<User> adduser = userRepository.findAllByRolerefid(roleid);
		return ResponseEntity.created(null).body(adduser);
	}

	public List getstockbalance(Integer cid, Integer bid, Integer lname, Integer lrefid, Integer prodid) {
		return PurchaseReqrepo.getstockbalance(cid, bid, lname, lrefid, prodid);
	}

	public ResponseEntity<Boolean> updatePurchaseReq(PurchaseRequisition pr, Integer userid, Integer status) {
		// TODO Auto-generated method stub
		PurchaseReqrepo.save(pr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> editreqform(PurchaseRequisition pr) {
		// TODO Auto-generated method stub
		PurchaseReqrepo.save(pr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> getRequisitionByuserid(Integer id, Integer userid, Integer status) {
		// TODO Auto-generated method stub
		//List<PurchaseRequisition> pr = PurchaseReqrepo.findByIdAndAcknowledgedbyuseridAndStatus(id, userid, status);
		List<PurchaseRequisition> pr = PurchaseReqrepo.findByIdAndAcknowledgedbyuseridAndStatus(id, userid, status);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> UpdateStatusAsAcknowledge(Integer id, Integer ackbyuserid, Integer status) {
		// TODO Auto-generated method stub

		PurchaseRequisition pr = PurchaseReqrepo.findAllByIdAndAcknowledgedbyuseridAndStatus(id, ackbyuserid, status);
		pr.setStatus(status);
		PurchaseReqrepo.save(pr);
		return ResponseEntity.created(null).body(pr);
	}

	public List vendlist(Integer cid, Integer bid, Integer lnid, Integer lrid) {

		return this.PurchaseReqrepo.vendlist(cid, bid, lnid, lrid);

	}

	public ResponseEntity<Boolean> createPurchaseReqProduct(List<PurchaseRequisitionProduct> pr) {
		for (PurchaseRequisitionProduct purchaseRequisitionProduct : pr) {
			purchaseRequisitionProduct.setPurcreqnoref(purchaseid);
			productRepo.save(purchaseRequisitionProduct);
		}
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> updatePurchaseReqProduct(List<PurchaseRequisitionProduct> pr) {
		// TODO Auto-generated method stub
		for(PurchaseRequisitionProduct prd:pr) {
		
			productRepo.save(prd);
		}
		
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> deletePurchaseReqProduct(Integer id) {
		PurchaseRequisitionProduct pr= productRepo.findById(id).get();
		pr.setStatus(5);
		productRepo.save(pr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> viewPurchaseReqProdbyid(Integer Purcreqnoref) {
		// TODO Auto-generated method stub
		List<PurchaseRequisitionProduct> pr = productRepo.findByPurcreqnoref(Purcreqnoref);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> GetPurcReqEditpagebyid(Integer prprodid) {
		// TODO Auto-generated method stub
		Optional<PurchaseRequisition> pr = PurchaseReqrepo.getPurcReqId(prprodid);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> GetPurcReqProductEditpagebyid(Integer prprodid) {
		// TODO Auto-generated method stub
		Optional<PurchaseRequisitionProduct> pr = productRepo.findById(prprodid);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> viewReqProdstatusBase(Integer userid, Integer status, Integer Purcreqnoref) {
		// TODO Auto-generated method stub
		List<PurchaseRequisitionProduct> pr = productRepo.findByPurcreqnoref(Purcreqnoref);
		return ResponseEntity.created(null).body(pr);
	}

	public ResponseEntity<?> AcknowledgerGetReq(String acknowledgeby, Integer status) {
		// TODO Auto-generated method stub
		List<PurchaseRequisition> li = PurchaseReqrepo.findAllByAcknowledgedbyAndStatus(acknowledgeby, status);
		return ResponseEntity.created(null).body(li);
	}

	public ResponseEntity<?> warehousedropdown(Integer cid,Integer loc) {
	List br=PurchaseReqrepo.warehousedropdown(cid,loc);
	return ResponseEntity.created(null).body(br);
	}

	public ResponseEntity<?> RequisitionStatus(Integer suserid) {
    	Integer status=PurchaseReqrepo.RequisitionStatus(suserid);
	    return ResponseEntity.created(null).body(status);
	}

//	public ResponseEntity<?> deleteonePreqallProd(Integer purcreqnoref) {
//		productRepo.deleteByPurcreqnoref(purcreqnoref);
//		return ResponseEntity.created(null).body(true);
//	}

//	public ResponseEntity<?> viewReqSingleProd(Integer purcreqprodid, Integer userid, Integer status) {
//		// TODO Auto-generated method stub
//		Optional<PurchaseRequisition> pr = PurchaseReqrepo.viewReqSingleProd(purcreqprodid,userid,status);
//		return ResponseEntity.created(null).body(pr);
//	}

	public ResponseEntity<?> UpdateStatusAcknowledge(Integer id, Integer ackid, Integer status) {
		Optional<PurchaseRequisition> pr=PurchaseReqrepo.findById(id);
		PurchaseRequisition pr1=pr.get();
//	    PurchaseRequisition pur=PurchaseReqrepo.getById(id);
//	    PurchaseRequisition pur1=  PurchaseReqrepo.getOne(id);
	    
		pr1.setAcknowledgedbyid(ackid);
	
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
			pr1.setAcknowledgeddate(dtf.format(now));
		pr1.setStatus(status);
		PurchaseReqrepo.save(pr1);
		  return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> UpdateStatusApprove(Integer id, Integer aprid, Integer status) {
		Optional<PurchaseRequisition> pr=PurchaseReqrepo.findById(id);
		PurchaseRequisition pr1=pr.get();
           pr1.setApprovedbyid(aprid);
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   pr1.setApproveddate(dtf.format(now));
			pr1.setStatus(status);
			PurchaseReqrepo.save(pr1);
			  return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> UpdateStatusRejected(Integer id, Integer rejid, Integer status) {
		Optional<PurchaseRequisition> pr=PurchaseReqrepo.findById(id);
		PurchaseRequisition pr1=pr.get();
           pr1.setRejectid(rejid);
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));  
		   pr1.setRejecteddate(dtf.format(now));
			pr1.setStatus(status);
			PurchaseReqrepo.save(pr1);
			  return ResponseEntity.created(null).body(true);
	}
	//mahalakshmi

	/*public List viewPurchaseProductbyid(Integer purcreqnoref) {
		List pr = productRepo.findAllByPurcreqnorefandprno(purcreqnoref);
		return pr;
	}*/
   // mahalakshmi multiple po concept
	public ResponseEntity<?> viewPoProductbyid(Integer purcreqnoref) {
		List<PurchaseRequisitionProduct> po = productRepo.findByPurcreqnorefandprno (purcreqnoref);
		return ResponseEntity.created(null).body(po);
	
	}

	//mahalakshmi delete api
	public Integer dlreqstatus(int purcreqprodid) throws Exception {
	 
		return productRepo.dlreqstatus(purcreqprodid);
	}


	

	}
	

