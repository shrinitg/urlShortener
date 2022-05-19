package com.example.urlShortener.entity;

import com.example.urlShortener.constant.TableConstants;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity(name = TableConstants.CONVERTED_URL)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvertedUrl {

    @Id
    @GeneratedValue(generator = TableConstants.GENERATOR)
    @GenericGenerator(name = TableConstants.GENERATOR, strategy = TableConstants.STRATEGY)
    private Long id;

    private String originalUrl;
    private String originalPath;
    private String convertedPath;
    private String convertedUrl;
    private Timestamp createdAt;


}
