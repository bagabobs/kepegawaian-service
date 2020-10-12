package len.bangtek.sibangtek.kepegawaian.adapter.out.persistence;

import len.bangtek.sibangtek.kepegawaian.application.port.out.HapusPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.application.port.out.LoadPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.application.port.out.RegistrasiPegawaiPort;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import len.bangtek.sibangtek.kepegawaian.util.PegawaiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PegawaiPersistenceAdapter implements RegistrasiPegawaiPort, LoadPegawaiPort, HapusPegawaiPort {
    @Autowired
    private PegawaiRepository pegawaiRepo;

    @Override
    public Optional<Pegawai> registrasi(Pegawai pegawai) {
        PegawaiEntity entityResult = pegawaiRepo.save(PegawaiMapper.rubahKePegawaiEntity(pegawai));
        return Optional.of(PegawaiMapper.rubahKePegawai(entityResult));
    }

    @Override
    public Optional<List<Pegawai>> loadPegawaiSemua() {
        List<PegawaiEntity> semuaPegawaiEntity = pegawaiRepo.findAll();
        return Optional.of(PegawaiMapper.rubahListKeListPegawai(semuaPegawaiEntity));
    }

    @Override
    public Optional<Pegawai> loadPegawaiByNik(String nik) {
        Optional<PegawaiEntity> pegawaiEntity = pegawaiRepo.cariPegawaiBerdasarkanNik(nik);
        return pegawaiEntity.flatMap(val -> Optional.of(PegawaiMapper.rubahKePegawai(val)));
    }

    @Override
    public Optional<List<Pegawai>> loadPegawaiByNama(String nama) {
        return pegawaiRepo.cariPegawaiSepertiNama(nama).flatMap(val -> Optional.of(PegawaiMapper.rubahListKeListPegawai(val)));
    }

    @Override
    public Optional<Pegawai> hapusPegawaiBerdasarkanNik(String nik) {
        pegawaiRepo.deleteById(nik);
        Optional<PegawaiEntity> pegawaiEntity = pegawaiRepo.cariPegawaiBerdasarkanNik(nik);
        return pegawaiEntity.flatMap(val -> Optional.of(PegawaiMapper.rubahKePegawai(val)));
    }
}
