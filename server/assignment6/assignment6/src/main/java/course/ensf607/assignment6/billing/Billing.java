package course.ensf607.assignment6.billing;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import course.ensf607.assignment6.customer.Customer;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "billing")
public class Billing implements Serializable {

        @Id
        @SequenceGenerator(
                name = "billing_sequence",
                sequenceName = "billing_sequence",
                allocationSize = 1
        )
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "billing_sequence"
        )
        private Long id;

        private Long cardNumber;

        private Date expiryDate;

        private int cvcNumber;

        @JsonIgnore
        @ManyToMany
        @JoinTable(
                name = "customers_attached",
                joinColumns = @JoinColumn(name = "billing_id"),
                inverseJoinColumns = @JoinColumn(name = "customer_id")
        )
        private Set<Customer> attachedCustomers = new HashSet<>();

        public Billing() {
        }

        public Billing(long id, Long cardNumber, Date expiryDate, int cvcNumber) {
                this.id = id;
                this.cardNumber = cardNumber;
                this.expiryDate = expiryDate;
                this.cvcNumber = cvcNumber;

        }
        
        public Billing(Long cardNumber, Date expiryDate, int cvcNumber) {
                this.cardNumber = cardNumber;
                this.expiryDate = expiryDate;
                this.cvcNumber = cvcNumber;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Long getCardNumber() {
                return cardNumber;
        }

        public void setCardNumber(Long cardNumber) {
                this.cardNumber = cardNumber;
        }

        public Date getExpiryDate() {
                return expiryDate;
        }

        public void setExpiryDate(Date expiryDate) {
                this.expiryDate = expiryDate;
        }

        public int getCvcNumber() {
                return cvcNumber;
        }

        public void setCvcNumber(int cvcNumber) {
                this.cvcNumber = cvcNumber;
        }

        public void addCustomer(Customer customer) {
                attachedCustomers.add(customer);
            }

        public Set<Customer> getAttachedCustomers() {
                return attachedCustomers;
        }

        public void setAttachedCustomers(Set<Customer> attachedCustomers) {
                this.attachedCustomers = attachedCustomers;
        }

        
}
