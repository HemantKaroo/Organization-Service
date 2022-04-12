package com.service.intelligence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.service.intelligence.model.Organization;

public interface OrganizationRepository extends CrudRepository<Organization, Long> {

	@Query("select o from Organization o where o.active=:status and (o.name like %:searchParam% or o.address like %:searchParam% or o.phoneOne like %:searchParam% or o.phoneTwo like %:searchParam% or o.emailOne like %:searchParam% or o.emailTwo like %:searchParam% or o.city like %:searchParam% or o.state like %:searchParam% or o.country like %:searchParam% or o.zipcode like %:searchParam%)")
	List<Organization> searchActiveOrganization(@Param("searchParam") String searchParam,@Param("status") String status);
	
	@Query("select o from Organization o where o.emailOne=:email or o.emailTwo=:email")
    Organization checkEmailId(@Param("email") String email);
	
	Organization findByName(String name);
}
