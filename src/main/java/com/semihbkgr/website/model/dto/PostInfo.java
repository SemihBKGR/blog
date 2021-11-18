package com.semihbkgr.website.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo {

    @Id
    private int id;

    @Column("subject_id")
    private int subjectId;

    private String title;

    private long createTime;

}
