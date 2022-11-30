package course.ensf607.assignment6.billing;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "billing")
public class Billing implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO) 
        private Long id;

        private Long cardNumber;

        private Date expiryDate;

        private Integer cvcNumber;

        private Long cus;
        
		public Billing(Long id, Long cardNumber, Date expiryDate, Integer cvcNumber, Long cus) {
			this.id = id;
			this.cardNumber = cardNumber;
			this.expiryDate = expiryDate;
			this.cvcNumber = cvcNumber;
			this.cus = cus;
		}

		public Billing(Long cardNumber, Date expiryDate, Integer cvcNumber, Long cus) {
			this.cardNumber = cardNumber;
			this.expiryDate = expiryDate;
			this.cvcNumber = cvcNumber;
			this.cus = cus;
		}
		

		
		
		
		
		
//      1
//      @OneToOne(mappedBy = "billing")	
//      private Customer customer;

//      2
//      @OneToOne
//      @MapsId
//      @JoinColumn(name = "customer_id")
      
//     2 reverse
//      @JsonIgnore
//  	@OneToOne(mappedBy = "billing", cascade = CascadeType.ALL)
//  	@PrimaryKeyJoinColumn
//      private Customer customer;
      
      
//      3
//      @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//      @JoinColumn(name = "customer_id", referencedColumnName = "id")
//      private Customer customer;
        
}
