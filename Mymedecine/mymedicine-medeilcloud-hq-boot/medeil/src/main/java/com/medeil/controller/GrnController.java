 package com.medeil.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.DeliveryProduct;
import com.medeil.domain.Grn;
import com.medeil.domain.Grnproduct;
import com.medeil.domain.Language;
import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseRequisition;
import com.medeil.domain.PurchaseRequisitionProduct;
import com.medeil.service.Grnservice;

/**Mahalakshmi**/
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class GrnController {
	@Autowired 
	private com.medeil.service.Grnservice Grnservice;
	
	
	
	/** CREATE Grn RECORD **/
	//Mahalakshmi
	@PostMapping(value = "/savegrn")
//	@Transactional
	public boolean createPurcinvoice(@RequestBody List<Grnproduct> gr) throws Exception {
		return Grnservice.createPurcinvoice(gr);
	}
	

//mahalakshmi
	@PostMapping(value = "/createGrn")
	public ResponseEntity<Boolean> createGrn(@RequestBody Grn gr) throws Exception {
		return Grnservice.createGrn(gr);
	}
	/**Update record**/
	
	@PostMapping(value = "updateGrnrecord")
	@Transactional
	public boolean updateGrnrecord(@RequestBody List<Grnproduct> gr) throws Exception {
		return Grnservice.updateGrnrecord(gr);
	}
	
	// MAHALAKSHMI grn updatemaintable
	

	@PostMapping(value = "/updateGrnmain")
	public ResponseEntity<Boolean> updateGrnmain(@RequestBody Grn gr) throws Exception {
		return Grnservice.updateGrnmain(gr);
	}
	//MAHALAKSHMI TO GET PO NO INTO GRN

	@GetMapping(value = "/purchaseorderpono/{comp}/{brnch}/{locname}/{locrefid}")
	public List purchaseorderpono(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return Grnservice.purchaseorderpono(comp, brnch, locname, locrefid);
	}
	//view api
	@GetMapping(value = "/viewgrnprocess/{comp}/{brnch}/{locname}/{locrefid}")
	public List viewgrnprocess(@PathVariable Integer comp, @PathVariable Integer brnch, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return Grnservice.viewgrnprocess(comp, brnch, locname, locrefid);
	}
	
	@GetMapping(value = "viewgrnproduct/{comid}/{branchid}/{locname}/{locrefid}")
	public List viewgrnproduct(@PathVariable Integer comid, @PathVariable Integer branchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		
		return Grnservice.viewgrnproduct(comid, branchid, locname, locrefid);

	}
	//delete api
	
	@GetMapping(value = "/deletegrn/{id}")
	public ResponseEntity<?> deletegrn(@PathVariable Integer id) throws Exception {
		return Grnservice.deletegrn(id);
		}
	// mahalakshmi dropdown api single id
	@GetMapping(value = "/viewgrndropid/{Poid}")
	public ResponseEntity<?> viewgrndropid(@PathVariable Integer Poid) {
		return Grnservice.viewgrndropid(Poid);

	}
	
	@GetMapping(value = "/viewgrnproducts/{compid}/{brnchid}/{loc}/{locrefid}/{poid}")
	public ResponseEntity<?> viewgrnproducts(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid,@PathVariable Integer poid) throws Exception {
		return Grnservice.viewgrnproducts(compid, brnchid, loc, locrefid , poid);
	}

	
	
	
	
}
