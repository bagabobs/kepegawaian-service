package len.bangtek.sibangtek.kepegawaian.adapter.out.persistence;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "pegawai")
public class PegawaiEntity {
    @Id
    @Column(name = "nik")
    private String nik;
    @Column(name = "bagian")
    private String bagian;
    @Column(name = "posisi")
    private String posisi;
    @Column(name = "nama")
    private String nama;
}
