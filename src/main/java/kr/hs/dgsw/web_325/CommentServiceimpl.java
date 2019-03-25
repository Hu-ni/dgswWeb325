package kr.hs.dgsw.web_325;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceimpl implements CommentService{

    @Autowired
    CommentRepository cr;

    @Autowired
    UserRepository ur;

    @Override
    public List<Comment> list() {
        return this.cr.findAll();
    }

    @Override
    public Comment view(Long id) {
        return this.cr.findById(id).orElse(null);
    }

    @Override
    public Comment add(Comment comment) {
        return this.cr.save(comment);
    }

    @Override
    public Comment update(Long id, Comment comment) {
        return this.cr.findById(id)
                .map(found -> {
                    found.setUserId(Optional.ofNullable(comment.getUserId()).orElse(found.getUserId()));
                    found.setComment(Optional.ofNullable(comment.getComment()).orElse(found.getComment()));
                    return this.cr.save(found);
                })
                .orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        try{
            this.cr.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public UserCommentProtocol findByuserId(Long userId) {
        return this.ur.findById(userId)
                .map( u -> new UserCommentProtocol(u, this.cr.findByUserId(userId)))
                .orElse(null);
    }

}
