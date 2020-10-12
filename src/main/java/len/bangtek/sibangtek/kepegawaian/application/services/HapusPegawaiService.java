package len.bangtek.sibangtek.kepegawaian.application.services;

import len.bangtek.sibangtek.kepegawaian.application.port.in.HapusPegawaiCommand;
import len.bangtek.sibangtek.kepegawaian.application.port.in.HapusPegawaiUseCase;
import len.bangtek.sibangtek.kepegawaian.application.port.out.HapusPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HapusPegawaiService implements HapusPegawaiUseCase {
    @Autowired
    private HapusPegawaiPort hapusPegawaiPort;

    @Override
    public Optional<Pegawai> hapusPegawai(HapusPegawaiCommand command) {
        Optional<Pegawai> opsiPegawai = hapusPegawaiPort.hapusPegawaiBerdasarkanNik(command.getNik());
        return opsiPegawai;
    }
}
