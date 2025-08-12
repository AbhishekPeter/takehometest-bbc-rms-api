 // Hooks code

 package hooks;

 import io.cucumber.java.After;
 import io.cucumber.java.Before;
 import io.cucumber.java.Scenario;
 import utils.Config;
 import utils.Log;

 public class TestHooks {


     @Before
     public void beforeScenario(Scenario scenario) {
         // WHY: Log the start of every scenario for traceability.
         Log.info("Starting Scenario: " + scenario.getName());

         // WHY: Load base URI from config.properties so we can switch environments easily.
         String baseUrl = Config.get("base_url");
     }

     @After
     public void afterScenario(Scenario scenario) {
         if (scenario.isFailed()) {
             Log.error("Scenario failed: " + scenario.getName()+ " - " + scenario.getStatus());
         } else {
             Log.info("Scenario passed: " + scenario.getName()+ " - " + scenario.getStatus());
         }
     }
 }

