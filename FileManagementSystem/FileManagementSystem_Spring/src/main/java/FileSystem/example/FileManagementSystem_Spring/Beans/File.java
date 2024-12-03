package FileSystem.example.FileManagementSystem_Spring.Beans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class File {

    @Length(min=1, max=32)
    private String name;
    private long size;
    private LocalDate creationDate;

}
