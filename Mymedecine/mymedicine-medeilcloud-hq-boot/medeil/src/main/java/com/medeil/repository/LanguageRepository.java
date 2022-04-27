package com.medeil.repository;


//maha//
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Language;





@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>
{

	List<Language> findByCompanyrefidAndBranchidAndLocnameAndLocrefid(Integer compid, Integer brnchid, Integer loc,
			Integer locrefid);

	
	List<Language> findByProductid(Integer productid);
	

	@Query(value = "	SELECT * from medc_custproductmaster cu INNER JOIN medc_language la on cu.ProductDrugID=la.productid\r\n" + 
			"", nativeQuery = true)
	List getproduct(int productid);


	List<Language> findByCompanyrefidAndBranchidAndLocnameAndLocrefidAndProductid(Integer compid, Integer brnchid,
			Integer loc, Integer locrefid, Integer productid);


	@Query(value="SELECT ProductDrugID  FROM medc_productmaster.medc_custproductmaster ORDER BY ProductDrugID DESC LIMIT 1",nativeQuery = true)
	Integer getLastId();


	

	


	
	

	
}
	



