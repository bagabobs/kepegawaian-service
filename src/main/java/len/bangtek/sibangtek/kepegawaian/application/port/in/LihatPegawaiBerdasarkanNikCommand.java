package len.bangtek.sibangtek.kepegawaian.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LihatPegawaiBerdasarkanNikCommand {
    private String nik;
}