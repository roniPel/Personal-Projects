package FileSystem.example.FileManagementSystem_Spring.Beans;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @Length(min=1, max=32)
    private String name;
    private long size;
    private LocalDate creationDate;
    @Column(name = "directory_name")
    @NotNull
    private String directoryName;

}
