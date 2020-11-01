package com.quorum.demo.network.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.quorum.demo.network.BaseResponseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogResponseData extends BaseResponseData
{

    @JsonProperty(value = "id")
    private Integer id;

    @JsonProperty(value = "title")
    private String title;

    @JsonProperty(value = "body")
    private String body;

    @JsonProperty(value = "image")
    private String image;

    @JsonProperty(value = "category")
    private String category;
}
