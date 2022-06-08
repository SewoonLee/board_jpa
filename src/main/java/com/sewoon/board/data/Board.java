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

    private Long id;                      // 기본키
    private String title;                     // 작성자
    private String content;         // 작성일자
    private int hits;                     // 별점*
    private String delete_yn;         // 리뷰 사진(사진 테이블)*
    private Date created_date;                         // 주문서 외래키
    private Date modified_date;                    // 예약 외래키(가이드 상품, 상품)
    private String passwd;


}
