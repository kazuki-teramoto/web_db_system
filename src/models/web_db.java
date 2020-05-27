package models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "tblsongtitle")
@NamedQueries({
    @NamedQuery(
            name = "getlist",
            query = "select w from web_db as w where w.song_title = :music_result or w.composition_ymd = :music_result ORDER BY w.song_id asc"
    ),
    @NamedQuery(
            name = "getalllist",
            query = "select w from web_db as w ORDER BY w.song_id asc"
    ),
    @NamedQuery(
            name = "checklist",
            query = "select count(w) from web_db as w where w.song_title = :music_result or w.composition_ymd = :music_result"
    ),
    @NamedQuery(
            name = "checkst",
            query = "select count(w) from web_db as w where w.song_title = :music_result"
    ),
    @NamedQuery(
            name = "checkymd",
            query = "select count(w) from web_db as w where w.composition_ymd = :music_result"
    )
})
@Entity
public class web_db {
    @Id
    @Column(name = "song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer song_id;

    @Column(name = "song_title")
    private String song_title;

    @Column(name = "comment")
    private String comment;

    @Column(name = "artist_num")
    private Integer artist_num;

    @Column(name = "tune_num")
    private Integer tune_num;

    @Column(name = "composition_ymd")
    private String composition_ymd;

    @Column(name = "series_num")
    private Integer series_num;



    public Integer getSong_id() {
        return song_id;
    }

    public void setSong_id(Integer song_id) {
        this.song_id = song_id;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public String getcomment() {
        return comment;
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }

    public Integer getArtist_num() {
        return artist_num;
    }

    public void setArtist_num(Integer artist_num) {
        this.artist_num = artist_num;
    }

    public Integer getTune_num() {
        return tune_num;
    }

    public void setTune_num(Integer tune_num) {
        this.tune_num = tune_num;
    }

    public String getComposition_ymd() {
        return composition_ymd;
    }

    public void setComposition_ymd(String composition_ymd) {
        this.composition_ymd = composition_ymd;
    }

    public Integer getSeries_num() {
        return series_num;
    }

    public void setSeries_num(Integer series_num) {
        this.series_num = series_num;
    }
}
