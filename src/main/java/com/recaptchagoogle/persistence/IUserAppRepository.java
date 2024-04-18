package com.recaptchagoogle.persistence;

import com.recaptchagoogle.entities.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAppRepository extends JpaRepository<UserApp,Long> {
}
