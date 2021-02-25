package github.benter.item;

import java.util.Arrays;
import java.util.List;
import github.benter.ImplantSlot;
import github.benter.item.curios.CuriosItem;
import net.minecraft.item.Item;

public class TestHead extends Item implements CuriosItem {

  public TestHead(Settings settings) {
    super(settings);
  }

  @Override
  public List<ImplantSlot> getSlots() {
    ImplantSlot[] slots = {ImplantSlot.HEAD};
    return Arrays.asList(slots);
  }
}
