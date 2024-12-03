package FileSystem.example.FileManagementSystem_Spring.Beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Directory {
    @Length(min=1, max=32)
    private String name;
    private LocalDate creationDate;
    private File file;
    private Directory directory;

}
