package aston.group86.hospitalboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cascade;
import org.hibernate.proxy.HibernateProxy;

/**
 * Класс, представляющий сущность доктора в системе.
 *
 * <p>Содержит информацию о докторе, включая его имя, фамилию, возраст, специальность,
 * а также список клиентов, прикрепленных к доктору.</p>
 *
 * <p>Связи:
 * <ul>
 *     <li>Один-ко-многим с сущностью {@link Client}: Доктор может быть связан с несколькими клиентами.</li>
 * </ul>
 * </p>
 *
 * <p>Использует аннотации JPA для сопоставления с таблицей "doctors" в базе данных, а также
 * аннотации Lombok для автоматической генерации методов геттеров, сеттеров, конструктора и equals/hashCode.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "doctor")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Doctor implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "doctor_id")
  private Long id;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "age")
  private int age;
  @Column(name = "specification")
  private String specification;
  @Column(name = "status")
  private String status;
  @OneToMany(mappedBy = "doctor", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
  @JsonManagedReference
  @ToString.Exclude
  @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
  private List<Client> clients;

  @PostLoad
  public void postLoad() {
    this.clients = new ArrayList<>(this.clients);
  }

  public Doctor(String firstName, String lastName, int age, String specification) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.specification = specification;
  }

  @Override
  public final boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer()
            .getPersistentClass() : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer()
            .getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) {
      return false;
    }
    Doctor doctor = (Doctor) o;
    return getId() != null && Objects.equals(getId(), doctor.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }
}
