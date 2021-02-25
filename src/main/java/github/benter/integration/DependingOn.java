package github.benter.integration;


import java.util.ArrayList;

public interface DependingOn {

  ArrayList<Integration> getDependencies();
  boolean dependsOn(Integration integration);

}
