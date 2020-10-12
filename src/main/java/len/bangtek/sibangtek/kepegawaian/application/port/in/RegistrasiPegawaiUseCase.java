package len.bangtek.sibangtek.kepegawaian.application.port.in;

import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface RegistrasiPegawaiUseCase {
    Optional<Pegawai> tambahPegawai(RegistrasiPegawaiCommand pegawaiCommand);

    @Value
    @EqualsAndHashCode(callSuper = false)
    class RegistrasiPegawaiCommand {
        @Valid
        @NotNull
        private final String nama;
        @NotNull
        private final String bagian;
        @NotNull
        private final String jabatan;
        @NotNull
        private final String nik;

        public RegistrasiPegawaiCommand(String nama, String bagian, String jabatan, String nik) {
            this.nama = nama;
            this.bagian = bagian;
            this.jabatan = jabatan;
            this.nik = nik;
        }
    }


}
