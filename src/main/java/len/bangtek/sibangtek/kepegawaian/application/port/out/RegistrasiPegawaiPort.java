package len.bangtek.sibangtek.kepegawaian.application.port.out;

import len.bangtek.sibangtek.kepegawaian.adapter.out.persistence.PegawaiEntity;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import java.util.Optional;

public interface RegistrasiPegawaiPort {
    Optional<Pegawai> registrasi(Pegawai pegawai);
}
