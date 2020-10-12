package len.bangtek.sibangtek.kepegawaian.application.port.in;

import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;

import java.util.Optional;

public interface HapusPegawaiUseCase {
    Optional<Pegawai> hapusPegawai(HapusPegawaiCommand command);
}
