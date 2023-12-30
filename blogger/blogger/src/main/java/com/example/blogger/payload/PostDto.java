package com.example.blogger.payload;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
public class PostDto {


    private long id;
    @NotEmpty
    @Size(min = 2,message = "Title should ne atleast 2 characters")
    private String title;
    @NotEmpty
    @Size(min = 4,message = "Description should ne atleast 2 characters")
    private String description;
    @NotEmpty
    @Size(min = 4,message = "content should ne atleast 2 characters")
    private String content;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
