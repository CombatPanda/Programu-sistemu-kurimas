package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.CostGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateGameCost implements Serializable {
    @Inject
    CostGenerator costGenerator;

    private CompletableFuture<Integer> costGenerationTask = null;

    @LoggedInvocation
    public String generateNewCost() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        costGenerationTask = CompletableFuture.supplyAsync(() -> costGenerator.generateCost());

        return  "/gameDetails.xhtml?faces-redirect=true&gameId=" + requestParameters.get("gameId");
    }

    public boolean isCostGenerationRunning() {
        return costGenerationTask != null && !costGenerationTask.isDone();
    }

    public String getCostGenerationStatus() throws ExecutionException, InterruptedException {
        if (costGenerationTask == null) {
            return null;
        } else if (isCostGenerationRunning()) {
            return "Cost generation in progress";
        }
        return "Suggested cost number: " + costGenerationTask.get();
    }
}
