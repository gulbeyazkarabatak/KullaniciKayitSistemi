package com.saatTeknoloji.kullaniciKayitSistemi.service;

import com.saatTeknoloji.kullaniciKayitSistemi.repository.KullaniciRepository;
import com.saatTeknoloji.kullaniciKayitSistemi.user.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class KullaniciService {


    private KullaniciRepository kullaniciRepository;

    public User createUser(User kullanici) {
        kullaniciRepository.save(kullanici);
        return kullanici;
    }

    public void deleteUser(Long kullaniciId) {
        kullaniciRepository.deleteById(kullaniciId);
    }
    public List<User> getAllUsers(){
         return kullaniciRepository.findAll();
    }
    public void updateUser (User user){
        User tempuser=kullaniciRepository.findOneById(user.getId());
        tempuser.setAd(user.getAd());
        tempuser.setSoyad(user.getSoyad());
        tempuser.setParola(user.getParola());
        tempuser.setEmail(user.getEmail());
        tempuser.setDogumTarihi(user.getDogumTarihi());
        kullaniciRepository.save(tempuser);
    }

}
