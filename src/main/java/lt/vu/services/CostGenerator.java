package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class CostGenerator implements Serializable {

    public Integer generateCost() {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        Integer generatedCost = new Random().nextInt(100);
        return generatedCost;
    }
}