package com.example.urlShortener.repository;

import com.example.urlShortener.entity.ConvertedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvertedUrlRepository extends JpaRepository<ConvertedUrl, Long> {

    ConvertedUrl findByConvertedPath(String string);

}
