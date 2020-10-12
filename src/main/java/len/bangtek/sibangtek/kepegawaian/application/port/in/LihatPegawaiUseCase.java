package len.bangtek.sibangtek.kepegawaian.application.port.in;

import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface LihatPegawaiUseCase {
    Optional<List<Pegawai>> lihatSemuaPegawai();
    Optional<Pegawai> lihatPegawaiBerdasarkanNik(LihatPegawaiBerdasarkanNikCommand nikCommand);
    Optional<List<Pegawai>> lihatPegawaiBerdasarkanNama(LihatPegawaiBerdasarkanNamaCommand namaCommand);
}
