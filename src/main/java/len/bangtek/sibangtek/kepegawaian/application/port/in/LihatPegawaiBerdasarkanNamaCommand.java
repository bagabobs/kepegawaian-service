package len.bangtek.sibangtek.kepegawaian.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LihatPegawaiBerdasarkanNamaCommand {
    private String nama;
}