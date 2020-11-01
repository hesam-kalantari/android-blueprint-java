package com.quorum.demo.network.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.quorum.demo.network.BaseResponseData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class BlogResponseData extends BaseResponseData
{
    @JsonUnwrapped
    private List<BlogDto> blogs;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogDto implements Serializable {
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
}
