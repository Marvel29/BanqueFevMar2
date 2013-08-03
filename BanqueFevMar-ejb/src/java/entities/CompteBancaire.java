/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marcelin Yvel
 */
@Entity
public class CompteBancaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double solde =0;

    public CompteBancaire() {
        
    }
    @OneToMany
    private List<OperationBancaire> operationBancaires;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CompteBancaire[ id=" + id + " ]";
    }
    public void depot(double montant){
         if ( montant<0) {
            montant =0-montant;
        }
         
        this.solde+= montant;           
        //return solde;
    }

    public void retrait(double montant){
        if ( montant<0) {
            montant =0-montant;
        }
}

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<OperationBancaire> getOperationBancaires() {
        return operationBancaires;
    }

    public void setOperationBancaires(List<OperationBancaire> operationBancaires) {
        this.operationBancaires = operationBancaires;
    }
}
