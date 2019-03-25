package kr.hs.dgsw.web_325;

import java.util.List;

public class UserCommentProtocol {
    User user;
    List<Comment> comments;

    public UserCommentProtocol(User user, List<Comment> comments) {
        this.user = user;
        this.comments = comments;
    }
}
