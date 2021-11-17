package com.semihbkgr.website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("tags")
public class Tag {

    private int id;

    @Column("subject_id")
    private int subjectId;

    private String name;

    private String explanation;

    private String imageUrl;

    private int displayOrder;

}
