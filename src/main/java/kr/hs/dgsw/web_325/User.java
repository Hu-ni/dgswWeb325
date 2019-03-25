package kr.hs.dgsw.web_325;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String email;

    @CreationTimestamp
    private LocalDateTime isined;
    @UpdateTimestamp
    private LocalDateTime modified;
}
