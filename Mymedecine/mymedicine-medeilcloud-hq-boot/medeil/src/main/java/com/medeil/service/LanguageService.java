package com.medeil.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.bean.LangBean;
import com.medeil.domain.Language;
import com.medeil.repository.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository Languagereqrepo;

	public ResponseEntity<Boolean> createLanguageReq(LangBean la) {
		Language language = new Language();
		Integer drugid = Languagereqrepo.getLastId();

		la.getActionIndications().forEach(a -> {
			language.setActionindicationenglish(a.getActionindicationeng());
			language.setActionindicationburmese(a.getActionindicationbur());
			language.setProductid(drugid);
			Languagereqrepo.save(language);
		});
		la.getPotentialsideeffects().forEach(p -> {
			language.setPotentialsideeffectsenglish(p.getPotentialsideeffectseng());
			language.setPotentialsideeffectsburmese(p.getPotentialsideeffectsbur());
			language.setProductid(drugid);
			Languagereqrepo.save(language);

		});
		la.getProductInformations().forEach(pr -> {
			language.setProductinformationenglish(pr.getProductinformationeng());
			language.setProductinformationburmese(pr.getProductinformationbur());
			language.setProductid(drugid);
			Languagereqrepo.save(language);

		});

		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> updateLanguageReq(Language la) {
		Languagereqrepo.save(la);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> deleteLanguageReq(Integer id) throws Exception {

		Languagereqrepo.deleteById(id);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> viewLanguageReqbyid(Integer id) {
		Optional<Language> la = Languagereqrepo.findById(id);
		return ResponseEntity.created(null).body(la);

	}

	public ResponseEntity<?> ViewLanguage(Integer compid, Integer brnchid, Integer loc, Integer locrefid) {

		List<Language> la = Languagereqrepo.findByCompanyrefidAndBranchidAndLocnameAndLocrefid(compid, brnchid, loc,
				locrefid);
		return ResponseEntity.created(null).body(la);
	}

	public ResponseEntity<?> viewid(Integer productid) {

		List<Language> la = Languagereqrepo.findByProductid(productid);
		return ResponseEntity.created(null).body(la);
	}

	public ResponseEntity<?> ViewLanguageid(Integer compid, Integer brnchid, Integer loc, Integer locrefid,
			Integer productid) {
		List<Language> la = Languagereqrepo.findByCompanyrefidAndBranchidAndLocnameAndLocrefidAndProductid(compid,
				brnchid, loc, locrefid, productid);
		return ResponseEntity.created(null).body(la);

	}

}
