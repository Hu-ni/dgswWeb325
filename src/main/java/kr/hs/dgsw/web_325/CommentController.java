package kr.hs.dgsw.web_325;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController{

    @Autowired
    private CommentService cs;

    @GetMapping("/list")
    public List<Comment> list(){
        return this.cs.list();
    }

    @GetMapping("/view/{id}")
    public Comment view(@PathVariable Long id){
        return this.cs.view(id);

//        Optional<Comment> found = this.cr.findById(id);
//        if (found.isPresent())
//            return found.get();
//        else
//            return null;
    }

    @PostMapping("/add")
    public Comment add(@RequestBody Comment comment){
        return this.cs.add(comment);
    }

    @PutMapping("/update/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        return this.cs.update(id,comment);

//        Optional<Comment> found = this.cr.findById(id);
//        if(found.isPresent()){
//            Comment f = found.get();
//            f.setAuthor(comment.getAuthor());
//            f.setComment(comment.getComment());
//            return this.cr.save(f);
//        }
//        else    return null;
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id){
        return this.cs.delete(id);
    }


    @GetMapping("/findbyuser/{userId}")
    public UserCommentProtocol findByuserId(@PathVariable Long userId){
        return this.cs.findByuserId(userId);
    }
}