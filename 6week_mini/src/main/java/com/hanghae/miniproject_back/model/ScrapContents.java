package com.hanghae.miniproject_back.model;

import com.hanghae.miniproject_back.dto.ScrapResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ScrapContents extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; //Conternts_id //PK 변하지않는 유니크한 키값


    @Column(nullable = false)
    private String username;
    private String title;
    private String des;
    private LocalDateTime modifiAt;

    @ManyToOne
    @JoinColumn(name = "contents_id")
    private Contents contents;

    public ScrapContents(String username, Contents contents){
        this.username = username;
        this.title = contents.getTitle();
        this.des = contents.getDes();
        this.modifiAt = contents.getModifiedAt();
        this.contents = contents;
    }


}
