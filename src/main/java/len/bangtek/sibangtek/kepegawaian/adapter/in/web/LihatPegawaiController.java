package len.bangtek.sibangtek.kepegawaian.adapter.in.web;

import len.bangtek.sibangtek.kepegawaian.application.port.in.LihatPegawaiBerdasarkanNamaCommand;
import len.bangtek.sibangtek.kepegawaian.application.port.in.LihatPegawaiBerdasarkanNikCommand;
import len.bangtek.sibangtek.kepegawaian.application.services.LihatPegawaiService;
import len.bangtek.sibangtek.kepegawaian.domain.Pegawai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pegawai")
public class LihatPegawaiController {
    @Autowired
    private LihatPegawaiService lihatPegawaiService;

    @GetMapping("/lihat_berdasarkan_nama/{nama}")
    public ResponseEntity<List<Pegawai>> lihatBerdasarkanNama(@PathVariable(value = "nama") String nama) {
        LihatPegawaiBerdasarkanNamaCommand command = new LihatPegawaiBerdasarkanNamaCommand(nama);
        Optional<List<Pegawai>> listPegawai = lihatPegawaiService.lihatPegawaiBerdasarkanNama(command);
        if(listPegawai.isEmpty()) {
            throw new NonExistingException();
        }
        return ResponseEntity.ok().body(listPegawai.get());
    }

    @GetMapping("/lihat_berdasarkan_nik/{nik}")
    public ResponseEntity<Pegawai> lihatBerdasarkanNik(@PathVariable(value = "nik") String nik) {
        Optional<Pegawai> pegawai = lihatPegawaiService.lihatPegawaiBerdasarkanNik(new LihatPegawaiBerdasarkanNikCommand(nik));
        if(pegawai.isEmpty()) {
            throw new NonExistingException();
        } else {
            return ResponseEntity.ok().body(pegawai.get());
        }
    }

    @GetMapping("/lihat_semua_pegawai")
    public ResponseEntity<List<Pegawai>> lihatSemua() {
        Optional<List<Pegawai>> listPegawai = lihatPegawaiService.lihatSemuaPegawai();
        if(listPegawai.isEmpty()) {
            throw new NonExistingException();
        }
        System.out.println("what this");
        return ResponseEntity.ok().body(listPegawai.get());
    }
}
