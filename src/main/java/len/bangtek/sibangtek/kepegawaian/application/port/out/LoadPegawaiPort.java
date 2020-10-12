package len.bangtek.sibangtek.kepegawaian.application.port.out;

import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;

import java.util.List;
import java.util.Optional;

public interface LoadPegawaiPort {
    Optional<List<Pegawai>> loadPegawaiSemua();
    Optional<Pegawai> loadPegawaiByNik(String nik);
    Optional<List<Pegawai>> loadPegawaiByNama(String nama);
}
