package com.semihbkgr.website.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("categories")
public class Category implements Serializable {

    @Id
    private int id;

    private String name;

    private String explanation;

    private String imageUrl;

    private int displayOrder;

}
