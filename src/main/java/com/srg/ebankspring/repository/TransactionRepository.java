package com.srg.ebankspring.repository;

import com.srg.ebankspring.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<User, Long> {
}
