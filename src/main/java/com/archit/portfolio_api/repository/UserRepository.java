package com.archit.portfolio_api.repository;

import com.archit.portfolio_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
