package backend.application.tp_module.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Table(name = "resources")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
    private List<FileEntity> files;

}
