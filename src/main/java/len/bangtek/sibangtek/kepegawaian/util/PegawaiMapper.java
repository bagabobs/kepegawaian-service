package len.bangtek.sibangtek.kepegawaian.util;

import len.bangtek.sibangtek.kepegawaian.adapter.out.persistence.PegawaiEntity;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;

import java.util.ArrayList;
import java.util.List;

public class PegawaiMapper {
    private PegawaiMapper pegawaiMapper;
    private PegawaiMapper() {}

    private static class SingletonHelper {
        private static final PegawaiMapper INSTANCE = new PegawaiMapper();
    }

    public static PegawaiMapper getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static Pegawai rubahKePegawai(PegawaiEntity pegawaiEntity) {
        Pegawai pegawai = new Pegawai();
        pegawai.setPosisi(pegawaiEntity.getPosisi());
        pegawai.setNik(pegawaiEntity.getNik());
        pegawai.setNama(pegawaiEntity.getNama());
        pegawai.setBagian(pegawaiEntity.getBagian());

        return pegawai;
    }


    public static PegawaiEntity rubahKePegawaiEntity(Pegawai pegawai) {
        PegawaiEntity pegawaiEntity = new PegawaiEntity();
        pegawaiEntity.setBagian(pegawai.getBagian());
        pegawaiEntity.setPosisi(pegawai.getPosisi());
        pegawaiEntity.setNama(pegawai.getNama());
        pegawaiEntity.setNik(pegawai.getNik());
        return pegawaiEntity;
    }

    public static List<Pegawai> rubahListKeListPegawai(List<PegawaiEntity> listPegawaiEntity) {
        List<Pegawai> listPegawai = new ArrayList<>();
        for(PegawaiEntity entity : listPegawaiEntity) {
           Pegawai pegawai = new Pegawai(entity.getNama(), entity.getNik(), entity.getBagian(), entity.getPosisi());
            listPegawai.add(pegawai);
        }
        return listPegawai;
    }

    public static List<PegawaiEntity> rubahListKeListPegawaiEntity(List<Pegawai> listPegawai) {
        List<PegawaiEntity> listPegawaiEntity = new ArrayList<>();
        for(Pegawai pegawai : listPegawai) {
            PegawaiEntity pegawaiEntity = new PegawaiEntity();
            pegawaiEntity.setBagian(pegawai.getBagian());
            pegawaiEntity.setPosisi(pegawai.getPosisi());
            pegawaiEntity.setNama(pegawai.getNama());
            pegawaiEntity.setNik(pegawai.getNik());
            listPegawaiEntity.add(pegawaiEntity);
        }
        return listPegawaiEntity;
    }
}
