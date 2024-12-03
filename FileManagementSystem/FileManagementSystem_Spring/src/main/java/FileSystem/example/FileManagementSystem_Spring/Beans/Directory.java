package FileSystem.example.FileManagementSystem_Spring.Beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Directory {
    @Id
    @GeneratedValue
    private int id;
    @Length(min=1, max=32)
    @Column(length = 32)
    private String name;
    private LocalDate creationDate;
    private File file;
    private Integer parentDirId;
}
