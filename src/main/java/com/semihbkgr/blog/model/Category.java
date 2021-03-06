package com.semihbkgr.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("categories")
public class Category {

    @Id
    private int id;

    private String name;

    private String explanation;

    private String imageUrl;

    private int displayOrder;

}
