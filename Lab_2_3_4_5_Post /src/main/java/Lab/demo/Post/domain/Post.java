package Lab.demo.Post.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String content;
    String autor;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    List<Comment> comments;
}
