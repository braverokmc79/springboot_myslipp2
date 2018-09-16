package net.slipp.domain;

import org.springframework.data.jpa.repository.JpaRepository;
//User id 타입import spock.util.mop.Use;
public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserId(String userId);
}
