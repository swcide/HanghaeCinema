package com.hanghae.cinema.model;

import com.hanghae.cinema.dto.request.ReviewRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "MOVIE_CODE", referencedColumnName = "MOVIE_CODE")
    @Column(nullable = false)
    private String moviecode;

    @Column(nullable = false)
    private String username;

    @Column(nullable = true)
    private String contents;

    private String password;

    @ColumnDefault("0")
    @Column(nullable = true)
    private int likecount;





    public Review(ReviewRequestDto reviewDto) {

        if (reviewDto.getContents() == "") {
            throw new IllegalArgumentException("내용이 비어있어요!");
        }
        this.username = reviewDto.getUsername();
        this.moviecode= reviewDto.getMoviecode();
        this.contents = reviewDto.getContents();
        this.likecount =reviewDto.getLikecount();

    }

    public void updateReview(ReviewRequestDto reviewDto) {
        this.username = reviewDto.getUsername();
        this.contents = reviewDto.getContents();
    }

    // 김진태 님 탓 ㅇㅈ?
}
