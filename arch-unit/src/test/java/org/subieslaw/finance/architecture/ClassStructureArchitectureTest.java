package org.subieslaw.finance.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaType;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_JARS;
import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_TESTS;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import org.junit.jupiter.api.Test;

public class ClassStructureArchitectureTest {

    private JavaClasses importedClasses = new ClassFileImporter()
                                                   .withImportOption(DO_NOT_INCLUDE_JARS)
                                                   .withImportOption(DO_NOT_INCLUDE_TESTS)
                                                   .importPackages("org.subieslaw.finance.demo");

    @Test
    public void should_derive_from_java_lang_object(){

        ArchCondition<JavaClass> shouldHaveObjectAsAParent = new ArchCondition<JavaClass>("can only have Object as superclass"){

            @Override
            public void check(JavaClass item, ConditionEvents events) {
                String fullName = item.getRawSuperclass().get().getFullName();
                boolean hasObjectAsParentClass = fullName.equals(Object.class.getName());
                String message = String.format(
                        "Class %s is extending %s not java.lang.Object", item.getName(), fullName);
                if (!hasObjectAsParentClass) {
                    events.add(SimpleConditionEvent.violated(item, message));
                }
            }
        };
        
        classes().that().areNotInterfaces().and().areNotEnums()
            .should(shouldHaveObjectAsAParent)
            .because("We prefer composition over interherance")
            .check(importedClasses);
    }
    
}
