package len.bangtek.sibangtek.kepegawaian.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PegawaiRepository extends JpaRepository<PegawaiEntity, String> {
    @Query(value = "SELECT a FROM PegawaiEntity a WHERE a.nik=?1")
    Optional<PegawaiEntity> cariPegawaiBerdasarkanNik(String nik);

    @Query(value = "SELECT a FROM PegawaiEntity a WHERE a.nama LIKE(?1)")
    Optional<List<PegawaiEntity>>  cariPegawaiSepertiNama(String nama);
}
