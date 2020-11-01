package com.quorum.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable
{
    private int id;
    private String title;
    private String body;
    private String image;
    private String category;
}
