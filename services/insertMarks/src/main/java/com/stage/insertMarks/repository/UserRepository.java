package com.stage.insertMarks.repository;

import com.stage.insertMarks.entity.Role;
import com.stage.insertMarks.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByIdentifier(String identifier);
    @Query("""
            select u from User u where u.idGrade= :idgrade and u.role= :role
            """)
    List<User> findByRoleAndGrade(Role role, int idgrade);
}

