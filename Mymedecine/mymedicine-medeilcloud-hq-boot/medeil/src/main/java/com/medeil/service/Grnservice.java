package com.medeil.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Drug;
import com.medeil.domain.Hsncode;
import com.medeil.domain.PoProduct;
import com.medeil.domain.PurchaseInvoice;
import com.medeil.domain.PurchaseRequisition;
import com.medeil.domain.PurchaseRequisitionProduct;
import com.medeil.domain.Stocks;
import com.medeil.domain.Grn;
import com.medeil.domain.Grnproduct;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.GrnRepository;
import com.medeil.repository.GrnmainRepository;
import com.medeil.repository.HsncodeRepository;
import com.medeil.repository.PoproductRepository;
import com.medeil.repository.PurchaseRepository;
import com.medeil.repository.PurchasenvoiceproRepository;
import com.medeil.repository.StocksRepository;
@SuppressWarnings("rawtypes")
@Service
public class Grnservice {
	
//venkat
	private static Logger logger = LogManager.getLogger();
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private GrnRepository purcprorepo;
	@Autowired
	private DrugRepository drugrepo;
	@Autowired
	private StocksRepository stkrepo;
	@Autowired
	private GrnRepository  grnrepo;

	@Autowired
	private PoproductRepository poproductRepository;
	@Autowired
	private HsncodeRepository hsnrepo;
	
	@Autowired
	private GrnmainRepository grnmainrepo;
	
	@PersistenceContext
	private EntityManager em;

	Query query;

	List list;
	Integer Grnno;
	int updateGrnno;
	
	@Transactional
	public boolean createPurcinvoice(List<Grnproduct> Grn) throws Exception {
	//public boolean createGrnrecord(Grnproduct grn)throws Exception  {
		boolean result = true;
		if (result == true) {
			for (Grnproduct p : Grn) {
				p.setPaflag(0);
				Integer batchid = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
				System.out.println("::::::::::::::::::::::::FOREACH" + batchid);
				if (batchid != null) {
					System.out.println("if_Condition::::" + batchid);
					p.setBatchno(batchid);
				} else {
					System.out.println(":::::::::::::::" + "Else" + batchid);
					System.out.println("::::::::::::::::::::::::::::::::::COmpanyid" + p.getCompanyrefid()
							+ p.getDrugproductrefid() + p.getBatchid());
					purcprorepo.insertbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
					// purchaseRepository.insertbatchid(purchaseinvoice.get(0).getCompanyrefid(),purchaseinvoice.get(0).getDrugproductrefid(),purchaseinvoice.get(0).getBatchid());
					System.out.println(
							"::::::::::::::::::::::::::::::::::COmpanyid" + Grn.get(0).getCompanyrefid());
					Integer batchidss = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
							p.getBatchid());
					p.setBatchno(batchidss);
					System.out.println("::::::::::::::::::::ElseCompleted" + batchidss);

				}
				List<Integer> PIID = purchaseRepository.getPIID(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(),
						p.getLocrefid());
				for (Integer PID : PIID) {
					System.out.println(">>>>>>>>>>>>>>>>.PIID" + PIID);
					p.setPirefid(PID);
				}
				Drug drug = drugrepo.findById(p.getDrugproductrefid()).get();
				// drug = drugrepo.findById(p.getDrugproductrefid()).get();
				drug.setGst(p.getGst());
				drug.setCgst(p.getCgst());
				drug.setSgst(p.getSgst());
				drug.setUtgst(p.getUtgst());
				drug.setIgst(p.getIgst());
				drug.setVat(p.getVat());
				drug.setHsnid(p.getHsnid());
				drugrepo.save(drug);
				if (p.getHsnid()!=null) {
					Optional<Hsncode> hsn = hsnrepo.findById(p.getHsnid());
					if (hsn.isPresent()) {
						hsn.get().setGst(p.getHsngst());
						hsnrepo.save(hsn.get());
					}
				}
	
				// hsn = hsnrepo.findById(p.getDrugproductrefid()).get();
				purcprorepo.save(p);
				Stocks stocks = new Stocks();
				stocks.setDrugproductid(p.getDrugproductrefid());
				stocks.setFormulationid(p.getFormulationid());
				stocks.setDosageid(p.getDosageid());
				stocks.setMrp(Double.valueOf(p.getMrp()));
				stocks.setSellingprice(Double.valueOf(p.getSellingprice()));
				stocks.setUnitprice(Double.valueOf(p.getUnitprice()));
				stocks.setUnitcgst(Double.valueOf(p.getCgst()));
				stocks.setUnitsgst(Double.valueOf(p.getSgst()));
				stocks.setUnitutgst(Double.valueOf(p.getUtgst()));
				stocks.setUnitigst(Double.valueOf(p.getIgst()));
				stocks.setUnitgst(Double.valueOf(p.getGst()));
				stocks.setVat(Double.valueOf(p.getVat()));
				stocks.setBatchname(p.getBatchid());
				stocks.setBatchno(p.getBatchno().toString());
				stocks.setQty(Double.valueOf(p.getTotalquantity()));
				stocks.setBoxperstrip(Double.valueOf(p.getStripperbox()));
				stocks.setStrippertablet(Double.valueOf(p.getQuantityperstrip()));
				stocks.setBoxqty(Double.valueOf(p.getBoxquantity()));
				stocks.setStripqty(0.00);
				stocks.setApprovalqty(0.00);
				stocks.setTabletqty(0.00);
				stocks.setFreeboxqty(Double.valueOf(p.getFreeboxqty()));
				stocks.setFreetabletqty(0.00);
				stocks.setFreetotalqty(Double.valueOf(p.getFreetotalqty()));
				stocks.setCompanyrefid(p.getCompanyrefid());
				stocks.setBranchrefid(p.getBranchrefid());
				stocks.setBatchname("NewBatchname"+p.getId());
				stocks.setLocname(p.getLocname());
				stocks.setLocrefid(p.getLocrefid());
				stocks.setExpirydate(p.getExpirydate());
				stocks.setPackageunit(p.getPackageunit());
				stocks.setPurchinvrefid(p.getPirefid());
				stocks.setPurchaseprice(Double.valueOf(p.getPurprice()));
				stocks.setDamagedestroystatus(0);
				stkrepo.save(stocks);
				Optional<PoProduct> optional = poproductRepository.findByPorefidAndDrugproductrefid(p.getRefpoid(),
						p.getDrugproductrefid());
				if (optional.isPresent()) {
					if (optional.get().getTotalquantity().equalsIgnoreCase(p.getTotalquantity())) {
						p.setPaflag(1);
						purcprorepo.save(p);
					}
				}
				purcprorepo.getupdateflag(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(), p.getLocrefid(),
						p.getRefpoid(), p.getDrugproductrefid());
				result = true;
			}

		} else {
			result = false;
		}
		return result;

	}

	public boolean createRecord(List<Grn> grn) {
		// TODO Auto-generated method stub
		return false;
	}

	//mahalakshmi save api grnmain
	public ResponseEntity<Boolean> createGrn(Grn gr) {
		Integer grnauto = grnmainrepo.grnauto(gr.getCompanyrefid(), gr.getBranchrefid(), gr.getLocname(),
				gr.getLocrefid());
		String GRNcode = String.format("%04d", (grnauto + 1));
		String GRN = "GRN" + GRNcode;
		System.out.println("GRN___________ " + GRN);
		gr.setGrnno(GRN);
		 Grnno = grnmainrepo.save(gr).getId();

		return ResponseEntity.created(null).body(true);	
		
	}
	//mahalakshmi upadte grntable

	public boolean updateGrnrecord(List<Grnproduct> gr)  throws Exception {
		
	boolean result = true;
	if (result == true) {
		for (Grnproduct p : gr) {
			p.setPaflag(0);
			try {
				System.out.println(p.getCompanyrefid() + " " + p.getBranchrefid() + " " + p.getLocname() + " "
						+ p.getLocrefid() + " " + p.getDrugproductrefid() + " " + p.getBatchid());
				Integer batchid = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
						p.getBatchid());

				if (batchid != null) {
					System.out.println("if_Condition::::" + batchid);
					p.setBatchno(batchid);
				} else {
					System.out.println(":::::::::::::::" + "Else" + batchid);
					purcprorepo.insertbatchid(p.getCompanyrefid(), p.getDrugproductrefid(), p.getBatchid());
					Integer batchidss = purcprorepo.getbatchid(p.getCompanyrefid(), p.getDrugproductrefid(),
							p.getBatchid());
					p.setBatchno(batchidss);
					System.out.println("::::::::::::::::::::ElseCompleted" + batchid);
				}

			

				purcprorepo.save(p);
				purcprorepo.getupdateflag(p.getCompanyrefid(), p.getBranchrefid(), p.getLocname(), p.getLocrefid(),
						p.getRefpoid(), p.getDrugproductrefid());

				Optional<Stocks> stocks = stkrepo
						.findByPurchinvrefidAndDrugproductidAndCompanyrefidAndLocrefidAndLocname(p.getPirefid(),
								p.getDrugproductrefid(), p.getCompanyrefid(), p.getLocrefid(), p.getLocname());
				if (stocks.isPresent()) {
					stocks.get().setDrugproductid(p.getDrugproductrefid());
					stocks.get().setFormulationid(p.getFormulationid());
					stocks.get().setDosageid(p.getDosageid());
					stocks.get().setMrp(Double.valueOf(p.getMrp()));
					stocks.get().setSellingprice(Double.valueOf(p.getSellingprice()));
					stocks.get().setUnitprice(Double.valueOf(p.getUnitprice()));
					stocks.get().setUnitcgst(Double.valueOf(p.getCgst()));
					stocks.get().setUnitsgst(Double.valueOf(p.getSgst()));
					stocks.get().setUnitutgst(Double.valueOf(p.getUtgst()));
					stocks.get().setUnitigst(Double.valueOf(p.getIgst()));
					stocks.get().setUnitgst(Double.valueOf(p.getGst()));
					stocks.get().setVat(Double.valueOf(p.getVat()));
					stocks.get().setBatchname(p.getBatchid());
					stocks.get().setBatchno(p.getBatchno().toString());
					stocks.get().setQty(Double.valueOf(p.getTotalquantity()));
					stocks.get().setBoxperstrip(Double.valueOf(p.getStripperbox()));
					stocks.get().setStrippertablet(Double.valueOf(p.getQuantityperstrip()));
					stocks.get().setBoxqty(Double.valueOf(p.getBoxquantity()));
					stocks.get().setFreetabletqty(Double.valueOf(p.getFreetabletqty()));
					stocks.get().setFreetotalqty(Double.valueOf(p.getFreetotalqty()));
					stocks.get().setCompanyrefid(p.getCompanyrefid());
					stocks.get().setBranchrefid(p.getBranchrefid());
					stocks.get().setLocname(p.getLocname());
					stocks.get().setLocrefid(p.getLocrefid());
					stocks.get().setExpirydate(p.getExpirydate());
					stocks.get().setPackageunit(p.getPackageunit());
					stocks.get().setPurchinvrefid(p.getPirefid());
					stocks.get().setPurchaseprice(Double.valueOf(p.getPurprice()));
					stkrepo.save(stocks.get());
				}

				
				result = true;
			}

			catch (Exception e) {
			
				throw new Exception(e);
			}

		}
	} 
	else {
		result = false;
	     }
	     return result;
	}

	public ResponseEntity<Boolean> updateGrnmain(Grn gr) {
		grnmainrepo.save(gr);
		updateGrnno = grnmainrepo.save(gr).getId();
		return ResponseEntity.created(null).body(true);
	
	}



	public List purchaseorderpono(Integer comp, Integer brnch, Integer locname, Integer locrefid) {
		return grnmainrepo.purchaseorderpono(comp, brnch,locname, locrefid);
		
	}

	public List viewgrnprocess(Integer comp, Integer brnch, Integer locname, Integer locrefid) {
		return grnmainrepo.viewgrnprocess(comp, brnch,locname, locrefid);
	}

	public List viewgrnproduct(Integer comid, Integer branchid, Integer locname, Integer locrefid) {
		return grnmainrepo.viewgrnprocess(comid, branchid,locname, locrefid);
	
	}

	public ResponseEntity<?> deletegrn(Integer id)throws Exception {
		Grn gr=grnmainrepo.findById(id).get();
		gr.setStatus(5);
		grnmainrepo.save(gr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> viewgrndropid(Integer poid) {
		List gr = grnmainrepo.findByPoid(poid);
		return ResponseEntity.created(null).body(gr);
		
	}

	
	public ResponseEntity<?> viewgrnproducts(Integer compid, Integer brnchid, Integer loc, Integer locrefid,
			Integer poid) {
		List<Grnproduct> gr = grnrepo.findByCompanyrefidAndBranchidAndLocnameAndLocrefidAndPoid(compid, brnchid, loc,
				locrefid,poid);
		return ResponseEntity.created(null).body(gr);

	}
	

	}
