package github.benter.item;

import github.benter.ImplantSlot;
import github.benter.annotation.CuriosAnnotation;
import github.benter.item.curios.CuriosItem;
import java.util.Arrays;
import java.util.List;
import net.minecraft.item.Item;

@CuriosAnnotation(slots = {ImplantSlot.CHEST, ImplantSlot.HEAD})
public class HeadBase extends Item implements CuriosItem {

  public HeadBase(Settings settings) {
    super(settings);
  }

  @Override
  public List<ImplantSlot> getSlots() {
    ImplantSlot[] slots = {ImplantSlot.HEAD, ImplantSlot.CHEST};
    return Arrays.asList(slots);
  }
}
