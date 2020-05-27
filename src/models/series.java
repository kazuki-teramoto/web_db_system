package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tblseries")
@NamedQueries({
    @NamedQuery(
            name = "getsr",
            query = "select w from series as w ORDER BY w.series_id asc"
    ),
    @NamedQuery(
            name = "checksr",
            query = "select count(w) from series as w where w.series_name = :music_result"
    )
})
@Entity
public class series {
    @Id
    @Column(name = "series_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer series_id;

    @Column(name = "series_name")
    private String series_name;

    public Integer getSeries_id() {
        return series_id;
    }

    public void setSeries_id(Integer series_id) {
        this.series_id = series_id;
    }

    public String getSeries_name() {
        return series_name;
    }

    public void setSeries_name(String series_name) {
        this.series_name = series_name;
    }
}
