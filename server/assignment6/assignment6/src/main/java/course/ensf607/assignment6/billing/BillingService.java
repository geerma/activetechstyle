package course.ensf607.assignment6.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    @Autowired
    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }


    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public void addNewBilling(Billing billing) {
        Optional<Billing> billingById = billingRepository.findBillingById(billing.getId());
        if (billingById.isPresent()) {
            throw new IllegalStateException("Billing already exist!");
        }
        billingRepository.save(billing);
    }

    public Billing getBillingById(Long billingId) {
        Optional<Billing> billingById = billingRepository.findById(billingId);
        if (!billingById.isPresent()) {
            throw new IllegalStateException("Billing doesn't exist!");
        }
        return billingById.get();
    }

    public void updateBilling(Billing billing) {
        billingRepository.save(billing);
    }
}
