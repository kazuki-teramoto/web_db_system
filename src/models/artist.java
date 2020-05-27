package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tblartist")
@NamedQueries({
    @NamedQuery(
            name = "getar",
            query = "select w from artist as w ORDER BY w.artist_id asc"
    ),
    @NamedQuery(
            name = "checkar",
            query = "select count(w) from artist as w where w.artist_name = :music_result"
    ),
    @NamedQuery(
            name = "getarlist",
            query = "select w from artist as w where w.artist_name = :music_result"

            )
})
@Entity
public class artist {
    @Id
    @Column(name = "artist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer artist_id;

    @Column(name = "artist_name")
    private String artist_name;

    public Integer getArtist() {
        return artist_id;
    }

    public void setArtist(Integer artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
}
