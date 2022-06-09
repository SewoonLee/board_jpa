package com.sewoon.board.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class
Board {

    private int id;
    private String title;
    private String content;
    private int hits;
//    private boolean delete_yn;
    private Date created_date;
    private Date updated_date;
    private String password;


}
