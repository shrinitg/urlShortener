package com.example.urlShortener.service;
import java.net.URISyntaxException;

public interface ShortenUrlService {

    String getShortenUrl(String longUrl) throws URISyntaxException;

}
