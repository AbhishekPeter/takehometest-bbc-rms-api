 // Hooks code

 package hooks;

 import io.cucumber.java.After;
 import io.cucumber.java.Before;
 import io.cucumber.java.Scenario;
 import utils.Log;

 public class TestHooks {

     @Before
     public void beforeScenario(Scenario scenario) {
         Log.info("Starting Scenario: " + scenario.getName());
     }

     @After
     public void afterScenario(Scenario scenario) {
         if (scenario.isFailed()) {
             Log.error("Scenario failed: " + scenario.getName());
         } else {
             Log.info("Scenario passed: " + scenario.getName());
         }
     }
 }

