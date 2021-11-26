package com.semihbkgr.website.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo implements Serializable {

    @Id
    private int id;

    @Column("subject_id")
    private int subjectId;

    @Column("category_id")
    private int categoryId;

    private String title;

    private String urlEndpoint;

    private int displayOrder;

    private long createTime;

}
