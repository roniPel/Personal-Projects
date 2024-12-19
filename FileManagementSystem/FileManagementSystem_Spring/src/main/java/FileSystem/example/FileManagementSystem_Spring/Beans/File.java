package FileSystem.example.FileManagementSystem_Spring.Beans;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class File {
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
//    private Integer id;
    @Length(max=32)
    private String name;
    private long size;
    private LocalDate creationDate;
    @Column(name = "directory_name")
    @NotNull
    private String directoryName;

    public String toString() {
        return new ToStringBuilder(this).
                append("name", name).
                append("creation date", creationDate).
                append("directory", directoryName).
                append("size", size).
                toString();
    }

}
