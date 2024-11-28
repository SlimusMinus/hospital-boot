package aston.group86.hospitalboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.proxy.HibernateProxy;

/**
 * Класс, представляющий сущность болезни в системе.
 *
 * <p>Содержит информацию о болезни, включая ее название и стадию.
 * Также содержит связь с клиентами, у которых зарегистрирована эта болезнь.</p>
 *
 * <p>Связи:
 * <ul>
 *     <li>Многие-ко-многим с сущностью {@link Client}: Болезнь может быть связана с несколькими клиентами.</li>
 * </ul>
 * </p>
 *
 * <p>Использует аннотации JPA для сопоставления с таблицей "sicks" в базе данных, а также
 * аннотации Lombok для автоматической генерации методов геттеров, сеттеров, конструктора и equals/hashCode.</p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "sick")
public class Sick implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sick_id")
    private Long id;

    @Column(name = "sick_name")
    private String sickName;

    @Column(name = "stage_sick")
    private String stageSick;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "sicks", cascade = {CascadeType.DETACH,
        CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnoreProperties("sicks")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE) // Кэшируем коллекцию
    private List<Client> clients;

    public Sick(String sickName, String stageSick) {
        this.sickName = sickName;
        this.stageSick = stageSick;
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
        Sick sick = (Sick) o;
        return getId() != null && Objects.equals(getId(), sick.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy proxy ? proxy.getHibernateLazyInitializer()
            .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
