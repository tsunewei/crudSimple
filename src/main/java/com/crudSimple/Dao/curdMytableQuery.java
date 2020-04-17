package com.crudSimple.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.crudSimple.Model.crudMytableJPA;

public interface curdMytableQuery extends JpaRepository<crudMytableJPA, Long> {
	List<crudMytableJPA> findByUsername(String username);

	@Query(value = "select id, username, passwd, systime from member.mytable where username = ?1 and passwd = ?2 ", nativeQuery = true)
	List<crudMytableJPA> findMytable(String username, String passwd);

	@Query(value = "select id, username, passwd, systime from member.mytable where id = ?1  ", nativeQuery = true)
	List<crudMytableJPA> findMytableByUpdate(int id);

	@Modifying
	@Transactional
	@Query(value = "update member.mytable set username = ?1 where id = ?2 ", nativeQuery = true)
	public void updatwMytableById(String username, int id);

	@Modifying
	@Transactional
	@Query(value = "insert into mytable(username, passwd, systime) values (?1,?2,NOW())", nativeQuery = true)
	public void insertMytable(String username, String passwd);
	
	@Modifying
	@Transactional
	@Query(value = "delete from member.mytable where id = ?1", nativeQuery = true)
	public void deleteMytableById(int id);
}
