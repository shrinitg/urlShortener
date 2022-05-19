package com.example.urlShortener.service.impl;

import com.example.urlShortener.constant.GeneralConstants;
import com.example.urlShortener.entity.ConvertedUrl;
import com.example.urlShortener.repository.ConvertedUrlRepository;
import com.example.urlShortener.service.ShortenUrlService;
import com.example.urlShortener.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URI;

@Service
@Slf4j
public class ShortenUrlServiceImpl implements ShortenUrlService {

    @Autowired
    private ConvertedUrlRepository convertedUrlRepository;

    @Override
    public String getShortenUrl(String longUrl) {
        String path = "";
        try {
            URI uri = new URI(longUrl);
            String host = uri.getHost();
            path = longUrl.substring(8+host.length());
            String randomCode = CommonUtil.generateRandomCode();
            String convertedUrl = String.format(GeneralConstants.CONVERTED_URL, randomCode);
            ConvertedUrl converted = ConvertedUrl.builder().convertedUrl(convertedUrl)
                    .convertedPath(randomCode).originalPath(path).originalUrl(longUrl).build();
            ConvertedUrl inserted = convertedUrlRepository.save(converted);

            return inserted.getConvertedUrl() == null ? "Url can not be shortened at the moment" : convertedUrl;

        } catch (Exception e) {
            log.error("Error while parsing the url {}", longUrl, e);
        }
        return path;
    }

}
