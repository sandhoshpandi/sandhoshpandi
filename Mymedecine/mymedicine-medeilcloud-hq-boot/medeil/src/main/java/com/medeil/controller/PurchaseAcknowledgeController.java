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

import com.medeil.domain.PurchaseAcknowledge;
import com.medeil.service.PurchaseAcknowledgeService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PurchaseAcknowledgeController {

	@Autowired
	PurchaseAcknowledgeService purchaseAcknowledgeService;

	
	//when superadmin login
	@GetMapping(value = "getRoleidandName/{compid}")
	public ResponseEntity<?> getRoleidandName(@PathVariable Integer compid) throws Exception {
		return purchaseAcknowledgeService.getRoleidandName(compid);
	}
	
	@GetMapping(value = "getemployeelist/{roleid}")
	public ResponseEntity<?> getemployeelist(@PathVariable Integer roleid) throws Exception {
		return purchaseAcknowledgeService.getemployeelist(roleid);
	}
	
	@PostMapping(value = "saveAsAcknowledge")
	public ResponseEntity<Boolean> saveAsAcknowledge(@RequestBody PurchaseAcknowledge pc)
			throws Exception {
		return purchaseAcknowledgeService.saveAsAcknowledge(pc);
	}
	
	@GetMapping(value = "/ViewPurchaseAcknowledge/{compid}/{brnchid}/{loc}/{locrefid}")
	public ResponseEntity<?> ViewPurchaseAcknowledge(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid) throws Exception {
		return purchaseAcknowledgeService.ViewPurchaseAcknowledge(compid, brnchid, loc, locrefid);
	}
	
}
