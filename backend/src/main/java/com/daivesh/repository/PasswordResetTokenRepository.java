package com.daivesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daivesh.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
