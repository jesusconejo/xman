package com.periferiag.xman.persistence.repository;

import com.periferiag.xman.persistence.entity.ADN;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdnRepository extends JpaRepository<ADN, Long> {

    boolean existsADNByAdn1AndAdn2AndAdn3AndAdn4AndAdn5AndAdn6(String uno, String dos, String tres, String cuatro, String cinco, String seis);
}
