package course.ensf607.assignment6.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import course.ensf607.assignment6.billing.Billing;
import course.ensf607.assignment6.cart.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "customer")
public class Customer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private String name;

	private String email;

	private String password;

    @OneToMany(mappedBy="customer")
    private Set<Cart> history = new HashSet<>();

	// 1
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "billing_id", referencedColumnName = "id")
    private Billing billing;
     
	// @JsonIgnore
	// @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	// @PrimaryKeyJoinColumn
	// private Billing billing;
	
	
    
    public Customer(Long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }



    
}

