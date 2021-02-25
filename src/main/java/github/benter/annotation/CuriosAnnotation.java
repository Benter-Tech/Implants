package github.benter.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import github.benter.ImplantSlot;

@Retention(RetentionPolicy.RUNTIME)
public @interface CuriosAnnotation {
  ImplantSlot[] slots();
}
