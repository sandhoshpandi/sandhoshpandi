package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.medeil.domain.PurchaseAcknowledge;
import com.medeil.domain.Role;
import com.medeil.domain.User;
import com.medeil.repository.PurchaseAcknowledgeRepository;
import com.medeil.repository.RoleRepository;
import com.medeil.repository.UserRepository;

@Service
public class PurchaseAcknowledgeService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PurchaseAcknowledgeRepository purchaseAcknowledgeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity<?> getRoleidandName(Integer compid) throws Exception {
		List<Role> ro = roleRepository.findByCompanyid(compid);
		return ResponseEntity.created(null).body(ro);
   }
	
	public ResponseEntity<?> getemployeelist(Integer roleid) throws Exception {

//		List<User> adduser = userRepository.findAllByRolerefid(roleid);
//		return ResponseEntity.created(null).body(adduser);
		List pac=purchaseAcknowledgeRepository.findAllByRoleid(roleid);
		return ResponseEntity.created(null).body(pac);
	}

	public ResponseEntity<Boolean> saveAsAcknowledge(PurchaseAcknowledge pc) {
		
		purchaseAcknowledgeRepository.save(pc);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> ViewPurchaseAcknowledge(Integer compid, Integer brnchid, Integer loc, Integer locrefid) {
		
		List<PurchaseAcknowledge> purchaseAck=purchaseAcknowledgeRepository.findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(compid,brnchid,loc,locrefid);
		
		return ResponseEntity.created(null).body(purchaseAck);
	}
	
	
	

}
