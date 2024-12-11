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
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Length(min=1, max=32)
    @Column(length = 32)
    private String name;
    private LocalDate creationDate;
    @OneToOne
    private List<File> files;
    @NotNull
    private int parentDirId;

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", files=" + files +
                ", parentDirId=" + parentDirId +
                '}';
    }
}
