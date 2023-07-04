package com.ust.websecurity.repository;

import com.ust.websecurity.entity.Issue;
import com.ust.websecurity.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue,Long> {
	List<Issue> findByUser();
	Optional<Issue> findByUserAndId(User user,Long id);
}
