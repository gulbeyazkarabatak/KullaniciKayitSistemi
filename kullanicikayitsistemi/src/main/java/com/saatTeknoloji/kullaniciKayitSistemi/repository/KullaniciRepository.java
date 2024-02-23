package com.saatTeknoloji.kullaniciKayitSistemi.repository;

import com.saatTeknoloji.kullaniciKayitSistemi.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciRepository  extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findOneById(Long id);


}
