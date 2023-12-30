import com.example.blogger.Post;
import com.example.blogger.payload.PostDto;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainUtil3 {

    public static void main(String[] args) {
        Post post1 = new Post();
        post1.setId(1);
        post1.setTitle("aaaa");
        post1.setContent("aaaa");

        Post post2 = new Post();
        post2.setId(2);
        post2.setTitle("bbbbb");
        post2.setContent("bbb");

        Post post3 = new Post();
        post3.setId(3);
        post3.setTitle("ccc");
        post3.setContent("ccccc");



//       PostDto dto1 = maptoDto(post1);
//       PostDto dto2 = maptoDto(post2);
//       PostDto dto3 = maptoDto(post3);

        List<Post> posts = Arrays.asList(post1,post2,post3);

        List<PostDto> dtos = posts.stream().map(p -> maptoDto(p)).collect(Collectors.toList());
        System.out.println(dtos);

    }

    static PostDto maptoDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());

        return dto;
    }
}
