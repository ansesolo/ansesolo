package com.alfsoftwares.honey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class HoneyApplicationTests {

  @Test
  void writeDocumentationSnippets() {

    ApplicationModules modules = ApplicationModules.of(HoneyApplication.class).verify();

    new Documenter(modules).writeModulesAsPlantUml().writeIndividualModulesAsPlantUml();
  }
}
