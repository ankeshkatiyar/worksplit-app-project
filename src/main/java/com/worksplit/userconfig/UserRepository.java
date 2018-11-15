package com.worksplit.userconfig;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Id> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findByMob(String mobile);
}
