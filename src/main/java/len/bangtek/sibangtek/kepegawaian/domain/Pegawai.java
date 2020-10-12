package len.bangtek.sibangtek.kepegawaian.domain;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pegawai {
    private String nama;
    private String nik;
    private String bagian;
    private String posisi;
}
