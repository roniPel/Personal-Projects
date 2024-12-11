package FileSystem.example.FileManagementSystem_Spring.Beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Length(min=1, max=32)
    @Column(length = 32)
    private String name;
    private LocalDate creationDate;
    @Singular
    @OneToMany(cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumn(name = "directory_id")
    private List<File> files;
    @NotNull
    private int parentDirId;

}
