package com.yjq.lagou.dao.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yjq.lagou.entity.common.User;

@Repository 
public interface UserDao extends JpaRepository<User, Long>{

	

	@Query("select u from User u where email = :email")
	public User findByEmail(String email);
	

	@Query(value="select * from user order by update_time desc limit :offset,:pageSize",nativeQuery=true)
	public List<User> findAllUserList(@Param("offset")int offset,@Param("pageSize")int pageSize);
	
	

	public User findByUsername(String username);
	

	@Query("select u from User u where id = :id")
	public User find(@Param("id")Long id);
}
