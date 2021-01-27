package com.raja.library_manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raja.library_manager.entity.Books;
import com.raja.library_manager.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	 @Query("select m from Member m where m.firstName Like:searchName OR m.lastName Like:searchName")
 public List<Member> findByfirstNameOrlastName(
           @Param("searchName") String searchName);

	 

	 

	
   
	 
	 

}
