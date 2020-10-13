package len.bangtek.sibangtek.kepegawaian.adapter.in.web;

import len.bangtek.sibangtek.kepegawaian.application.port.in.HapusPegawaiCommand;
import len.bangtek.sibangtek.kepegawaian.application.services.HapusPegawaiService;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pegawai")
public class HapusPegawaiController {
    @Autowired
    private HapusPegawaiService service;

    @DeleteMapping("/delete_by_id/{nik}")
    public ResponseEntity<Pegawai> hapus(@PathVariable String nik) {
        Optional<Pegawai> pegawai = service.hapusPegawai(new HapusPegawaiCommand(nik));
        if(pegawai.isEmpty()) {
            throw new NonExistingException();
        }
        return ResponseEntity.ok().body(pegawai.get());
    }
}
