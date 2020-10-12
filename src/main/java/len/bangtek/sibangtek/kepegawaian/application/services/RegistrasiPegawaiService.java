package len.bangtek.sibangtek.kepegawaian.application.services;

import len.bangtek.sibangtek.kepegawaian.application.port.in.RegistrasiPegawaiUseCase;
import len.bangtek.sibangtek.kepegawaian.application.port.out.RegistrasiPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrasiPegawaiService implements RegistrasiPegawaiUseCase {
    @Autowired
    private RegistrasiPegawaiPort registrasiPegawaiPort;

    @Override
    public Optional<Pegawai> tambahPegawai(RegistrasiPegawaiCommand pegawaiCommand) {
        Pegawai pegawai = changePegawaiCommandToPegawai(pegawaiCommand);
        Optional<Pegawai> optionalPegawai = registrasiPegawaiPort.registrasi(pegawai);
        return optionalPegawai;
    }

    private Pegawai changePegawaiCommandToPegawai(RegistrasiPegawaiCommand cmd) {
        return new Pegawai(cmd.getNama(), cmd.getNik(), cmd.getBagian(), cmd.getJabatan());
    }
}
