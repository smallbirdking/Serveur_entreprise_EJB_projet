package fr.unice.polytech.se.demo.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by ding on 31/03/15.
 */
public class HoraireVente implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer debutLindi;
    private Integer finLindi;
    private Integer debutMardi;
    private Integer finMardi;
    private Integer debutMercredi;
    private Integer finMercredi;
    private Integer debutJeudi;
    private Integer finJeudi;
    private Integer debutVendredi;
    private Integer finVendredi;
    private Integer debutSamedi;
    private Integer finSamedi;
    private Integer debutDimanche;
    private Integer finDimanche;

    public HoraireVente(){

    }

    public String toString(){
        return "HORAIREVENTE[" + this.id + "]#"
                +"\nLindi:" + this.debutLindi + "-" + this.finLindi
                +"\nMardi:" + this.debutMardi + "-" + this.finMardi
                +"\nMercredi:" + this.debutMercredi + "-" + this.finMercredi
                +"\nJeudi:" + this.debutJeudi + "-" + this.finJeudi
                +"\nVendredi:" + this.debutVendredi + "-" + this.finVendredi
                +"\nSamedi:" + this.debutSamedi + "-" + this.finSamedi
                +"\nDimanche:" + this.debutDimanche + "-" + this.finDimanche;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_HORAIREVENTE",length = 32)
    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Column(name = "DEBUTLINDI")
    @NotNull
    public Integer getDebutLindi(){
        return this.debutLindi;
    }

    public void setDebutLindi(Integer i){
        debutLindi = i;
    }
    @Column(name = "FINLINDI")
    @NotNull
    public Integer getFinLindi(){
        return this.finLindi;
    }

    public void setFinLindi(Integer i){
        finLindi = i;
    }
    @Column(name = "DEBUTMARDI")
    @NotNull
    public Integer getDebutMardi(){
        return this.debutMardi;
    }

    public void setDebutMardi(Integer i){
        debutMardi = i;
    }
    @Column(name = "FINMARDI")
    @NotNull
    public Integer getFinMardi(){
        return this.finMardi;
    }

    public void setFinMardi(Integer i){
        finMardi = i;
    }
    @Column(name = "DEBUTMERCREDI")
    @NotNull
    public Integer getDebutMercredi(){
        return this.debutMercredi;
    }

    public void setDebutMercredi(Integer i){
        debutMercredi = i;
    }
    @Column(name = "FINMERCREDI")
    @NotNull
    public Integer getFinMercredi(){
        return this.finMercredi;
    }

    public void setFinMercredi(Integer i){
        finMercredi = i;
    }
    @Column(name = "DEBUTJEUDI")
    @NotNull
    public Integer getDebutJeudi(){
        return this.debutJeudi;
    }

    public void setDebutJeudi(Integer i){
        debutJeudi = i;
    }
    @Column(name = "FINJEUDI")
    @NotNull
    public Integer getFinJeudi(){
        return this.finJeudi;
    }

    public void setFinJeudi(Integer i){
        finJeudi = i;
    }
    @Column(name = "DEBUTVENDREDI")
    @NotNull
    public Integer getDebutVendredi(){
        return this.debutVendredi;
    }

    public void setDebutVendredi(Integer i){
        debutVendredi = i;
    }
    @Column(name = "FINVENDREDI")
    @NotNull
    public Integer getFinVendredi(){
        return this.finVendredi;
    }

    public void setFinVendredi(Integer i){
        finVendredi = i;
    }
    @Column(name = "DEBUTSAMEDI")
    @NotNull
    public Integer getDebutSamedi(){
        return this.debutSamedi;
    }

    public void setDebutSamedi(Integer i){
        debutSamedi = i;
    }
    @Column(name = "FINSAMEDI")
    @NotNull
    public Integer getFinSamedi(){
        return this.finSamedi;
    }

    public void setFinSamedi(Integer i){
        finSamedi = i;
    }
    @Column(name = "DEBUTDIMANCHE")
    @NotNull
    public Integer getDebutDimanche(){
        return this.debutDimanche;
    }

    public void setDebutDimanche(Integer i){
        debutDimanche = i;
    }
    @Column(name = "FINDIMANCHE")
    @NotNull
    public Integer getFinDimanche(){
        return this.finDimanche;
    }

    public void setFinDimanche(Integer i){
        finDimanche = i;
    }
}
