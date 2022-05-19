package com.example.urlShortener.util;

import com.example.urlShortener.entity.ConvertedUrl;
import com.example.urlShortener.repository.ConvertedUrlRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

@Slf4j
public class CommonUtil {

    @Autowired
    private static ConvertedUrlRepository convertedUrlRepository;

    public static String generateRandomCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString;
        do {
            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        while (!checkIfUnique(generatedString));

        return generatedString;
    }

    private static Boolean checkIfUnique(String stringToCheck) {
        ConvertedUrl convertedUrl = convertedUrlRepository.findByConvertedPath(stringToCheck);
        return convertedUrl == null;
    }

}
