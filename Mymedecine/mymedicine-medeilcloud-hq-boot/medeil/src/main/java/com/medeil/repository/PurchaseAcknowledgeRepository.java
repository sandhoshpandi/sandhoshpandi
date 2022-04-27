package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PurchaseAcknowledge;

@Repository
public interface PurchaseAcknowledgeRepository extends JpaRepository<PurchaseAcknowledge, Integer> {

	List<PurchaseAcknowledge> findByCompanyrefidAndBranchrefidAndLocnameAndLocrefid(Integer compid, Integer brnchid,
			Integer loc, Integer locrefid);

	@Query(value = "SELECT ad.CompanyRefID,ad.RoleRefID,ad.SUserRefID,ad.customername,us.EmpRefID FROM medc_adminsecurity.medc_userlogin us INNER JOIN medc_adminsecurity.medc_adduser ad on  us.SUserID=ad.SUserRefID where ad.RoleRefID=?1", nativeQuery = true)
	List  findAllByRoleid(Integer roleid);

}
