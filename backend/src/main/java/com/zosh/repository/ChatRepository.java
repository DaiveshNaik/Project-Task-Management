package com.daivesh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daivesh.model.Chat;
import com.daivesh.model.Project;

public interface ChatRepository extends JpaRepository<Chat, Long> {

	Chat findByProject(Project projectById);

	// List<Chat> findByProjectNameContainingIgnoreCase(String projectName);
}
