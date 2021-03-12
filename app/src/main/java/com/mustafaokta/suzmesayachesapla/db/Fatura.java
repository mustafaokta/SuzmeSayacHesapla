package com.mustafaokta.suzmesayachesapla.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;




@Entity
public class Fatura {
    @Id(autoincrement = true)
    private Long id;
    private String sayacTanimlamasi;
    private Date faturaOkunmaTarihi;
    private Integer faturaSayacIlkEndeks;
    private Integer faturaSayacSonEndeks;
    private Integer suzmeSayacIlkEndeks;
    private Integer suzmeSayacSonEndeks;
    private Integer faturaSayacEndeksFark;
    private Integer suzmeSayacEndeksFark;
    private Integer faturaToplamTutar;
    private Integer suzmeSayacHesaplananFaturaPayi;
    @Generated(hash = 2059541262)
    public Fatura(Long id, String sayacTanimlamasi, Date faturaOkunmaTarihi,
            Integer faturaSayacIlkEndeks, Integer faturaSayacSonEndeks,
            Integer suzmeSayacIlkEndeks, Integer suzmeSayacSonEndeks,
            Integer faturaSayacEndeksFark, Integer suzmeSayacEndeksFark,
            Integer faturaToplamTutar, Integer suzmeSayacHesaplananFaturaPayi) {
        this.id = id;
        this.sayacTanimlamasi = sayacTanimlamasi;
        this.faturaOkunmaTarihi = faturaOkunmaTarihi;
        this.faturaSayacIlkEndeks = faturaSayacIlkEndeks;
        this.faturaSayacSonEndeks = faturaSayacSonEndeks;
        this.suzmeSayacIlkEndeks = suzmeSayacIlkEndeks;
        this.suzmeSayacSonEndeks = suzmeSayacSonEndeks;
        this.faturaSayacEndeksFark = faturaSayacEndeksFark;
        this.suzmeSayacEndeksFark = suzmeSayacEndeksFark;
        this.faturaToplamTutar = faturaToplamTutar;
        this.suzmeSayacHesaplananFaturaPayi = suzmeSayacHesaplananFaturaPayi;
    }
    @Generated(hash = 313897821)
    public Fatura() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getSayacTanimlamasi() {
        return this.sayacTanimlamasi;
    }
    public void setSayacTanimlamasi(String sayacTanimlamasi) {
        this.sayacTanimlamasi = sayacTanimlamasi;
    }
    public Date getFaturaOkunmaTarihi() {
        return this.faturaOkunmaTarihi;
    }
    public void setFaturaOkunmaTarihi(Date faturaOkunmaTarihi) {
        this.faturaOkunmaTarihi = faturaOkunmaTarihi;
    }
    public Integer getFaturaSayacIlkEndeks() {
        return this.faturaSayacIlkEndeks;
    }
    public void setFaturaSayacIlkEndeks(Integer faturaSayacIlkEndeks) {
        this.faturaSayacIlkEndeks = faturaSayacIlkEndeks;
    }
    public Integer getFaturaSayacSonEndeks() {
        return this.faturaSayacSonEndeks;
    }
    public void setFaturaSayacSonEndeks(Integer faturaSayacSonEndeks) {
        this.faturaSayacSonEndeks = faturaSayacSonEndeks;
    }
    public Integer getSuzmeSayacIlkEndeks() {
        return this.suzmeSayacIlkEndeks;
    }
    public void setSuzmeSayacIlkEndeks(Integer suzmeSayacIlkEndeks) {
        this.suzmeSayacIlkEndeks = suzmeSayacIlkEndeks;
    }
    public Integer getSuzmeSayacSonEndeks() {
        return this.suzmeSayacSonEndeks;
    }
    public void setSuzmeSayacSonEndeks(Integer suzmeSayacSonEndeks) {
        this.suzmeSayacSonEndeks = suzmeSayacSonEndeks;
    }
    public Integer getFaturaSayacEndeksFark() {
        return this.faturaSayacEndeksFark;
    }
    public void setFaturaSayacEndeksFark(Integer faturaSayacEndeksFark) {
        this.faturaSayacEndeksFark = faturaSayacEndeksFark;
    }
    public Integer getSuzmeSayacEndeksFark() {
        return this.suzmeSayacEndeksFark;
    }
    public void setSuzmeSayacEndeksFark(Integer suzmeSayacEndeksFark) {
        this.suzmeSayacEndeksFark = suzmeSayacEndeksFark;
    }
    public Integer getFaturaToplamTutar() {
        return this.faturaToplamTutar;
    }
    public void setFaturaToplamTutar(Integer faturaToplamTutar) {
        this.faturaToplamTutar = faturaToplamTutar;
    }
    public Integer getSuzmeSayacHesaplananFaturaPayi() {
        return this.suzmeSayacHesaplananFaturaPayi;
    }
    public void setSuzmeSayacHesaplananFaturaPayi(
            Integer suzmeSayacHesaplananFaturaPayi) {
        this.suzmeSayacHesaplananFaturaPayi = suzmeSayacHesaplananFaturaPayi;
    }

   


}
