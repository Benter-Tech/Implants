package github.benter.integration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Integration {
  ORIGINS("origins"),
  COMPUTER_CRAFT("computercraft");

  private final String MOD_ID;

}
