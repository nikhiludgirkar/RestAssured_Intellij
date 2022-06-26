package com.bookstore.pojo.practise.posts;

import com.bookstore.utils.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostsPayloadGen {

    public static PostsPojo getPostsData() throws IOException {

        List<PostsPojo.Posts> listPost = new ArrayList<PostsPojo.Posts>();
        PostsPojo.Posts p = new PostsPojo.Posts();
        p.setAuthor((String) JsonParser.readJsonFile("posts", String.valueOf("author")));
        p.setId(Integer.parseInt((String) JsonParser.readJsonFile("posts", String.valueOf("id"))));
        p.setTitle((String) JsonParser.readJsonFile("posts", String.valueOf("title")));

        listPost.add(p);
        PostsPojo postsPojo = new PostsPojo();
        postsPojo.setPosts(listPost);
        return postsPojo;
    }
}
