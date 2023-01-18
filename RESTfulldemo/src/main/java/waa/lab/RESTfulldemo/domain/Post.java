package waa.lab.RESTfulldemo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    long id;
    String tittle;
    String content;
    String publisher;
}
