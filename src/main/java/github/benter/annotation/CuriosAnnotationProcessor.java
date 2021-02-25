package github.benter.annotation;

import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("net.fabricmc.benter.annotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CuriosAnnotationProcessor extends AbstractProcessor {

  @Override
  public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
    System.out.println("process custom annotation");
    for ( TypeElement annotation : set ) {
      for ( Element element : roundEnvironment.getElementsAnnotatedWith(annotation) ) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @CuriosAnnotation at " + element);
      }
    }
    return true;
  }

}
