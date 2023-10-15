package com.afam.cocodeapi.Repositories;

import com.afam.cocodeapi.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT CASE WHEN COUNT(user) > 0 THEN true ELSE false END FROM UserModel user WHERE user.email = ?1")
    boolean existsByEmail(String email);

    @Query("SELECT user FROM UserModel user WHERE user.email = ?1")
    Optional<UserModel> findByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(user) > 0 THEN true ELSE false END FROM UserModel user WHERE user.username = ?1")
    boolean existsByUsername(String username);

    @Query("SELECT user FROM UserModel user WHERE user.username = ?1")
    Optional<UserModel> findByUsername(String username);


}
