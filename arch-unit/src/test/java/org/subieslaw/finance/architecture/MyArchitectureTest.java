package org.subieslaw.finance.architecture;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.CompositeArchRule;

import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_TESTS;
import static com.tngtech.archunit.lang.CompositeArchRule.of;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

public class MyArchitectureTest {
    
    private JavaClasses importedClasses = new ClassFileImporter()
                                                   .withImportOption(DO_NOT_INCLUDE_TESTS)
                                                   .importPackages("org.subieslaw.finance.demo");
    @Test
    public void classes_should_have_final_fields() {
        ArchRule rule = classes()
                            .that()
                            .arePublic()
                            .should()
                            .haveOnlyFinalFields()
                            .because("We would like to keep our object Immutable.");

        rule.check(importedClasses);
    }

    @Test
    public void classes_should_have_private_constructors() {
        ArchRule rule = classes()
                            .that()
                            .arePublic()
                            .should()
                            .haveOnlyPrivateConstructors()
                            .because("We would like to limit Object creation outside package.");
                            
        rule.check(importedClasses);
    }

    @Test
    public void classes_should_not_use_obsolete_java_features(){
        CompositeArchRule myRule = of(NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
                                    .and(NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS)
                                    .and(NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING)
                                    .and(NO_CLASSES_SHOULD_USE_JODATIME)
                                    .and(NO_CLASSES_SHOULD_USE_FIELD_INJECTION);
                                    
        myRule.because("We should not use obsolete Java features.")
        .check(importedClasses);
    }

}
