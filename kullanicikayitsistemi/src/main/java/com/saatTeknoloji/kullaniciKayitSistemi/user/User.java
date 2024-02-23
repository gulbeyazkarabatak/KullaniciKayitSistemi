package com.saatTeknoloji.kullaniciKayitSistemi.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity(name = "User")
@Table(name = "kullanici")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class   User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ad;

	private String soyad;

	@Column(name ="email", unique=true)
	private String email;

	private Date dogumTarihi;

	private String parola;

	public User (String ad, String soyad, String email, String parola, String dogumTarihi){
		this.ad = ad;
		this.soyad = soyad;
		this.email = email;
		this.parola = parola;
		this.dogumTarihi = Date.valueOf(dogumTarihi);
	}

}


