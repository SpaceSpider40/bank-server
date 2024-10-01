package space.bank_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.bank_server.entity.user.ContactInfo;

public interface IContactInfoRepository extends JpaRepository<ContactInfo, Long> {
}
