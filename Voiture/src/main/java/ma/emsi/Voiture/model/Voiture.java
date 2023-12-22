package ma.emsi.Voiture.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marque;
    private String matricule;
    private String model;

    @Transient @ManyToOne
    private Client client;

    public Voiture(Long id, String marque, String matricule, String model, Client client) {
        this.id = id;
        this.marque = marque;
        this.matricule = matricule;
        this.model = model;
        this.client = client;
    }

	public Voiture() {
	}

    public Voiture(String marque, String matricule, String model, Client client) {
        this.marque = marque;
        this.matricule = matricule;
        this.model = model;
        this.client = client;
    }
}
