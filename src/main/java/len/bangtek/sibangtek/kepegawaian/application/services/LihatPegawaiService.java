package len.bangtek.sibangtek.kepegawaian.application.services;

import len.bangtek.sibangtek.kepegawaian.adapter.out.persistence.PegawaiEntity;
import len.bangtek.sibangtek.kepegawaian.application.port.in.LihatPegawaiBerdasarkanNamaCommand;
import len.bangtek.sibangtek.kepegawaian.application.port.in.LihatPegawaiBerdasarkanNikCommand;
import len.bangtek.sibangtek.kepegawaian.application.port.in.LihatPegawaiUseCase;
import len.bangtek.sibangtek.kepegawaian.application.port.out.LoadPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import len.bangtek.sibangtek.kepegawaian.util.PegawaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LihatPegawaiService implements LihatPegawaiUseCase {
    @Autowired
    private LoadPegawaiPort loadPegawaiPort;

    @Override
    public Optional<List<Pegawai>> lihatSemuaPegawai() {
        Optional<List<Pegawai>> opsiListPegawai = loadPegawaiPort.loadPegawaiSemua();
        return opsiListPegawai;
    }

    @Override
    public Optional<Pegawai> lihatPegawaiBerdasarkanNik(LihatPegawaiBerdasarkanNikCommand nikCommand) {
        Optional<Pegawai> opsiPegawai = loadPegawaiPort.loadPegawaiByNik(nikCommand.getNik());
        return opsiPegawai;
    }

    @Override
    public Optional<List<Pegawai>> lihatPegawaiBerdasarkanNama(LihatPegawaiBerdasarkanNamaCommand namaCommand) {
        Optional<List<Pegawai>> lihatPegawai = loadPegawaiPort.loadPegawaiByNama(namaCommand.getNama());
        return lihatPegawai;
    }
}
