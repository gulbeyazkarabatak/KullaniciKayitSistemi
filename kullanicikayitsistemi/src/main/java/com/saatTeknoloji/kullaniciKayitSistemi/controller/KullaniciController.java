package com.saatTeknoloji.kullaniciKayitSistemi.controller;

import org.springframework.web.bind.annotation.PutMapping;
import com.saatTeknoloji.kullaniciKayitSistemi.service.KullaniciService;
import com.saatTeknoloji.kullaniciKayitSistemi.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@RestController
@RequestMapping("/kullanicilar")
public class KullaniciController {

    @Autowired
    private KullaniciService kullaniciService;


    @GetMapping
    public List<User> getAllUsers() {
        return kullaniciService.getAllUsers();
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User kullanici) {
        try {
            User createdUser = kullaniciService.createUser(kullanici);
            ResponseEntity<User> kullaniciResponseEntity = new ResponseEntity<>(createdUser, CREATED);
            return kullaniciResponseEntity;
        } catch (IllegalArgumentException e) {
            ResponseEntity<User> kullaniciResponseEntity = new ResponseEntity<>(BAD_REQUEST);
            return kullaniciResponseEntity;
        }
    }

    @DeleteMapping("/{kullaniciId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long kullaniciId) {
        kullaniciService.deleteUser(kullaniciId);
        return new ResponseEntity<>(NO_CONTENT);
    }

    @PutMapping("/edituser")
    private User update(@RequestBody User user) {
        kullaniciService.updateUser(user);
        return user;
    }
}
