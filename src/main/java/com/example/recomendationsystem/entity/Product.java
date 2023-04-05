package com.example.recomendationsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = Product.TABLE_NAME)
public class Product {

    public static final String TABLE_NAME = "PRODUCTS";
    public static final String SEQ_NAME = TABLE_NAME + "_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "author")
    private String author;

    @Column(name = "album")
    private String album;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "genre")
    private String genre;

    @Column(name = "year_of_issue")
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date yearOfIssue;

    @Lob
    @Column(name = "file")
    private byte[] file;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "audio_text_video_id", referencedColumnName = "id")
//    private AudioTextVideo audioTextVideo;
}
