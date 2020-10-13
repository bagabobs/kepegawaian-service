package len.bangtek.sibangtek.kepegawaian.adapter.in.web;

import len.bangtek.sibangtek.kepegawaian.application.port.in.RegistrasiPegawaiUseCase;
import len.bangtek.sibangtek.kepegawaian.application.services.RegistrasiPegawaiService;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pegawai")
public class RegistrasiPegawaiController {
    @Autowired
    private RegistrasiPegawaiService service;

    @PostMapping("/registrasi")
    public ResponseEntity<Pegawai> registrasi(@RequestParam(value = "nama") String nama,
                                                                @RequestParam(value = "nik") String nik,
                                                                @RequestParam(value = "bagian") String bagian,
                                                                @RequestParam(value = "jabatan") String jabatan) {
        try {
            RegistrasiPegawaiUseCase.RegistrasiPegawaiCommand cmd = new RegistrasiPegawaiUseCase.RegistrasiPegawaiCommand(nama, bagian, jabatan, nik);
            Optional<Pegawai> hasilTambah = service.tambahPegawai(cmd);
            if (hasilTambah.isEmpty()) {
                throw new NonExistingException();
            } else {
                return ResponseEntity.ok().body(hasilTambah.get());
            }
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            throw new ValueInvalidException();
        }
    }
}

