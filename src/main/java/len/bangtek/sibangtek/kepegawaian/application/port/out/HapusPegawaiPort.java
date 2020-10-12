package len.bangtek.sibangtek.kepegawaian.application.port.out;

import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;

import java.util.Optional;

public interface HapusPegawaiPort {
   Optional<Pegawai> hapusPegawaiBerdasarkanNik(String nik);
}
