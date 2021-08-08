package org.subieslaw.finance.architecture;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaPackage;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.metrics.ArchitectureMetrics;
import com.tngtech.archunit.library.metrics.ComponentDependencyMetrics;
import com.tngtech.archunit.library.metrics.MetricsComponents;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_JARS;
import static com.tngtech.archunit.core.importer.ImportOption.Predefined.DO_NOT_INCLUDE_TESTS;

import java.util.Set;

public class ArchitectureMetricsTest {
    
    private JavaClasses importedClasses = new ClassFileImporter()
                                                   .withImportOption(DO_NOT_INCLUDE_JARS)
                                                   .withImportOption(DO_NOT_INCLUDE_TESTS)
                                                   .importPackages("org.subieslaw.finance");

    @Test
    public void check_architecture_metrics(){

        Set<JavaPackage> packages = importedClasses.getPackage("org.subieslaw.finance").getSubpackages();
        MetricsComponents<JavaClass> components = MetricsComponents.fromPackages(packages);
       
        ComponentDependencyMetrics metrics = ArchitectureMetrics.componentDependencyMetrics(components);
        
        System.out.println("Ce: " + metrics.getEfferentCoupling("org.subieslaw.finance.demo"));
        System.out.println("Ca: " + metrics.getAfferentCoupling("org.subieslaw.finance.demo"));
        System.out.println("I: " + metrics.getInstability("org.subieslaw.finance.demo"));
        System.out.println("A: " + metrics.getAbstractness("org.subieslaw.finance.demo"));
        System.out.println("D: " + metrics.getNormalizedDistanceFromMainSequence("org.subieslaw.finance.demo"))   ;
    }

}
