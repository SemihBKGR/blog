package com.semihbkgr.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("posts")
public class Post implements Serializable {

    @Id
    private int id;

    @Column("subject_id")
    private int subjectId;

    @Column("category_id")
    private int categoryId;

    private String title;

    private String brief;

    private String content;

    private String urlEndpoint;

    private String imageUrl;

    private int displayOrder;

    private long createTime;

    private long updateTime;

}
