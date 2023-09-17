package com.example.fileuploadingsystem.data;

import com.example.fileuploadingsystem.api.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT new com.example.fileuploadingsystem.api.UserDto(U.name, U.surname, U.login) " +
            "FROM User U " +
            "WHERE U.name = :searchQuery " +
            "OR U.surname = :searchQuery " +
            "OR U.login = :searchQuery ")
    Page<UserDto> getUsersCustom(Pageable pageable, @Param("searchQuery") String searchQuery);
}