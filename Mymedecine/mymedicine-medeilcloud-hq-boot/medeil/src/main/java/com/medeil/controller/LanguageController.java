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

import com.medeil.bean.LangBean;
import com.medeil.domain.Language;
import com.medeil.repository.LanguageRepository;
import com.medeil.service.LanguageService;
//maha//

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class LanguageController {
	@Autowired
	private LanguageService LanguageReqService;

	@PostMapping(value = "/createLanguage")
	public ResponseEntity<Boolean> createLanguageReq(@RequestBody LangBean la) throws Exception {
		return LanguageReqService.createLanguageReq(la);
	}

	@PostMapping(value = "/updateLanguage")
	public ResponseEntity<Boolean> updateLanguageReq(@RequestBody Language la) throws Exception {
		return LanguageReqService.updateLanguageReq(la);
	}

	@GetMapping(value = "/deleteLanguage/{id}")
	public ResponseEntity<?> deleteLanguageReq(@PathVariable Integer id) throws Exception {
		return LanguageReqService.deleteLanguageReq(id);
	}

	@GetMapping(value = "/viewLanguagebyid/{id}")
	public ResponseEntity<?> viewLanguageReqbyid(@PathVariable Integer id) {
		return LanguageReqService.viewLanguageReqbyid(id);
	}

	@GetMapping(value = "/ViewLanguage/{compid}/{brnchid}/{loc}/{locrefid}")
	public ResponseEntity<?> ViewLanguage(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid) throws Exception {
		return LanguageReqService.ViewLanguage(compid, brnchid, loc, locrefid);
	}

	@GetMapping(value = "/viewid/{productid}")
	public ResponseEntity<?> viewid(@PathVariable Integer productid) {
		return LanguageReqService.viewid(productid);
	}

	@GetMapping(value = "/ViewLanguageid/{compid}/{brnchid}/{loc}/{locrefid}/{productid}")
	public ResponseEntity<?> ViewLanguageid(@PathVariable Integer compid, @PathVariable Integer brnchid,
			@PathVariable Integer loc, @PathVariable Integer locrefid, @PathVariable Integer productid)
			throws Exception {
		return LanguageReqService.ViewLanguageid(compid, brnchid, loc, locrefid, productid);
	}

}
