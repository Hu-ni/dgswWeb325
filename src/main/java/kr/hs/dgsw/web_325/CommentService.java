package kr.hs.dgsw.web_325;

import java.util.List;

public interface CommentService {
    List<Comment> list();
    Comment view(Long id);
    Comment add(Comment comment);
    Comment update(Long id, Comment comment);
    boolean delete(Long id);
    UserCommentProtocol findByuserId(Long userId);
}
