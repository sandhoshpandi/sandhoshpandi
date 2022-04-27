package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.DrugImage;

@SuppressWarnings("rawtypes")
@Repository
public interface DrugImageRepository extends JpaRepository<DrugImage, Integer> {

	@Modifying
	@Transactional
	@Query(value = "INSERT into  medc_productmaster.medc_custproductmasterimages (image_url, image_filename, drugproductid) values ( ?1,?2,?3) ", nativeQuery = true)
	int uploadDrugImage( String filepath,String filename1, int updateid);

	
	@Query(value = "SELECT m.image_url FROM medc_productmaster.medc_custproductmasterimages m where  m.drugproductid=?1 ", nativeQuery = true)
	List<String> getImageUrl(Integer drugid);


	@Query(value = "SELECT m.imageid FROM medc_productmaster.medc_custproductmasterimages m where  m.drugproductid=?1 ", nativeQuery = true)
	List<Integer> getImageId(Integer drugid);


	List<DrugImage> findByDrugproductid(Integer drugid);



	@Modifying
	@Transactional
	@Query(value = "delete from medc_productmaster.medc_custproductmasterimages where DrugProductID=?1 ", nativeQuery = true)
	void deleteDrugPhotos(Integer productdrugid);


	

	
	

	

}
