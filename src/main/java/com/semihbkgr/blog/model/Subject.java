package com.semihbkgr.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("subjects")
public class Subject {

    @Id
    private int id;

    private String name;

    private String explanation;

    private String urlEndpoint;

    private String imageUrl;

    private int displayOrder;

}
