package github.benter;

import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.util.Identifier;

@AllArgsConstructor
@Getter
public enum ImplantSlot {
  HEAD,
  CHEST,
  LEGS,
  FEET;

  public String getSlotKey(){
    return Implants.MODID+"_"+ this.name().toLowerCase(Locale.ROOT);
  }

  public Identifier getIdentifier(){
    return new Identifier(Implants.MODID, "gui/"+this.getSlotKey()+"_icon");
  }
}
