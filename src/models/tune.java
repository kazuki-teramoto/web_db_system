package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tbltune")
@NamedQueries({
    @NamedQuery(
            name = "gettu",
            query = "select w from tune as w ORDER BY w.tune_id asc"
    ),
    @NamedQuery(
            name = "checktu",
            query = "select count(w) from tune as w where w.tune_name = :music_result"
    )
})
@Entity
public class tune {
    @Id
    @Column(name = "tune_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tune_id;

    @Column(name = "tune_name")
    private String tune_name;

    public Integer getTune_id() {
        return tune_id;
    }

    public void setTune_id(Integer tune_id) {
        this.tune_id = tune_id;
    }

    public String getTune_name() {
        return tune_name;
    }

    public void setTune_name(String tune_name) {
        this.tune_name = tune_name;
    }
}
