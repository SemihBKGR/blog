package com.semihbkgr.website.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo {

    @Id
    private int id;

    private int subjectId;

    private String tagName;

    private String title;

    private String brief;

    private String imageUrl;

    private long createTime;

}
