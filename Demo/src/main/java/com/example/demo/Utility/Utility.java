package com.example.demo.Utility;

import com.example.demo.Domain.Admin;
import com.example.demo.Domain.Anime;
import com.example.demo.exeption.ResourceNotFoundExeption;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.AnimeRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.demo.Utility.Constants.*;

@Component
public class Utility {

    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime) {

        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }

    public Anime findAnimeOrThrowNotFound(int id, AnimeRepository animeRepository) {

        return animeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Anime Not Found"));
    }

    public Admin findAdminOrThrowNotFound(int id, AdminRepository adminRepository) {

        return adminRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Anime Not Found"));
    }

    public String isValidEmail(String email) {

        String result = "";
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        if(!m.matches()) {

            result = EMAIL_VALIDATION;
        }
        return result;
    }

    public String isValidPassword(String passsword) {

        String result = "";
        if(passsword.length() < PASSWORD_MIN) {

            return PASSWORD_VALIDATION_1;
        }
        if(passsword.length() > PASSWORD_MAX) {

            return PASSWORD_VALIDATION_2;
        }
        return result;
    }
}
